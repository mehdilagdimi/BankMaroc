package com.bank.service;

import com.bank.model.Agent;
import com.bank.model.Client;
import com.bank.model.ConfirmationToken;
import com.bank.model.UserRole;
import com.bank.repository.ClientRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class ClientServiceImpl implements ClientService, UserDetailsService {

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
        Optional<Client> client = clientRepo.findByUsername(username);
        return clientRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Client not found......"));
    }

    public String signUpClient(Client client){
        boolean userExists = clientRepo.findByUsername(client.getUsername()).isPresent();
        if(userExists) {
            throw new IllegalStateException("Client's username is already used !");
        }
        String encodedPassword = bCryptPasswordEncoder.encode(client.getPassword());
        client.setPassword(encodedPassword);
        clientRepo.save(client);

        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(token, LocalDateTime.now(), LocalDateTime.now().plusMinutes(3), client);
        confirmationTokenService.saveConfirmationToken(confirmationToken);
        return "the client token is : "+token;
    }
}
