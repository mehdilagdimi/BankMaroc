package com.bank.service;

import com.bank.model.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientService {
    Client saveClient(Client client);
    //  Client getClient(String username);
    List<Client> getClients();
}
