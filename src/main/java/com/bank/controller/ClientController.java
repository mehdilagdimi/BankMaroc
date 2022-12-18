package com.bank.controller;

import com.bank.model.Client;
import com.bank.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor

public class ClientController {

    private final ClientService clientService;

    @GetMapping("/clients")
    public ResponseEntity<List<Client>> getClients(){
        return ResponseEntity.ok().body(clientService.getClients());
    }


    @PostMapping("/client/save")
    public ResponseEntity<Client> saveClient(@RequestBody Client client){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/client/save").toUriString());
        return ResponseEntity.created(uri).body(clientService.saveClient(client));
    }
}
