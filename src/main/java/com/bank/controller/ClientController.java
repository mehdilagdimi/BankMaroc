package com.bank.controller;

import com.bank.model.Client;
import com.bank.service.ClientService;
import com.bank.service.RegistrationRequest;
import com.bank.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequestMapping
@RestController
@RequiredArgsConstructor

public class ClientController {

    private final ClientService clientService;
    private final RegistrationService registrationService;

    @GetMapping("/clients")
    public ResponseEntity<List<Client>> getClients(){
        return ResponseEntity.ok().body(clientService.getClients());
    }


    @PostMapping("/client/save")
    public ResponseEntity<Client> saveClient(@RequestBody Client client){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/client/save").toUriString());
        return ResponseEntity.created(uri).body(clientService.saveClient(client));
    }

    @PostMapping("/registration/client")
    public String register(@RequestBody RegistrationRequest request){
        return registrationService.register(request);
    }

}
