package com.bank.controller;

import com.bank.model.Client;
import com.bank.service.ClientService;
import com.bank.service.helpers.RegistrationRequest;
import com.bank.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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



    @PostMapping("/registration/client")
    public String register(@RequestBody RegistrationRequest request){
        return registrationService.register(request);
    }

}
