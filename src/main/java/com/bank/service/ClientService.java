package com.bank.service;

import com.bank.model.Client;

import java.util.List;

public interface ClientService {
    Client saveClient(Client client);
    Client getClient(String username);
    List<Client> getClients();
}
