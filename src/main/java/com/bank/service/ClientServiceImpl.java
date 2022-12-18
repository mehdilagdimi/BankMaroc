package com.bank.service;

import com.bank.model.Client;
import com.bank.model.UserRole;
import com.bank.repository.ClientRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class ClientServiceImpl implements ClientService , UserDetailsService {

    private final ClientRepo clientRepo;

    @Override
    public Client saveClient(Client client) {
        log.info("client is saving ...");
        return clientRepo.save(client);
    }

    @Override
    public Client getClient(String username) {
        log.info("fetching client {}",username);
        return clientRepo.findByUsername(username);
    }

    @Override
    public List<Client> getClients() {
        log.info("fetching all clients");
        return clientRepo.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Client client = clientRepo.findByUsername(username);
        if(client == null){
            log.error("client not found......");
            throw new UsernameNotFoundException("client not found......");
        } else {
            log.info("client {} found in DB....", username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(UserRole.CLIENT.name()));
        return new org.springframework.security.core.userdetails.User(client.getUsername(),client.getPassword(), authorities);
    }
}
