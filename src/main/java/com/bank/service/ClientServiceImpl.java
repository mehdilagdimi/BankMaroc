package com.bank.service;

import com.bank.model.Client;
import com.bank.model.ConfirmationToken;
import com.bank.model.User;
import com.bank.repository.ClientRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class ClientServiceImpl implements ClientService, UserDetailsService {

    public static String uploadDir = System.getProperty("client.dir")+"src/main/resources/static";

    private final ClientRepo clientRepo;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    @Override
    public Client saveClient(Client client) {
        log.info("client is saving ...");
        return clientRepo.save(client);
    }

     /*@Override
    public Client getClient(String username) {
        log.info("fetching client {}",username);
        return clientRepo.findByUsername(username);
    }

      */

    @Override
    public List<Client> getClients() {
        log.info("fetching all clients");
        return clientRepo.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      //  Optional<Client> client = clientRepo.findByUsername(username);
        return clientRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Client not found......"));
    }

    public String signUpClient(Client client){
        System.out.println( "inside client registration signup");

        boolean userExists = clientRepo.findByUsername(client.getUsername()).isPresent();
        if(userExists) {
            throw new IllegalStateException("Client's username is already used !");
        }
        System.out.println( "inside client registration signup");

        String encodedPassword = bCryptPasswordEncoder.encode(client.getPassword());
        client.setPassword(encodedPassword);
        clientRepo.save(client);
        System.out.println( "inside client registration signup");
        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(token, LocalDateTime.now(), LocalDateTime.now().plusMinutes(10), client);
        confirmationTokenService.saveConfirmationToken(confirmationToken);
        return "the client token is : "+token;

    }

    public User loadUserByEmail(String email) throws UsernameNotFoundException {
//        Optional<Client> client = clientRepo.findByUsername(username);
        return clientRepo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Client not found......"));
    }
}
