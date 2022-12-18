package com.bank.service;

import com.bank.model.Client;
import com.bank.repository.ClientRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class ClientServiceImpl implements ClientService{

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
}
