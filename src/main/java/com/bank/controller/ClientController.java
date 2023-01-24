package com.bank.controller;

import com.bank.model.Client;
import com.bank.repository.ClientRepo;
import com.bank.service.ClientService;
import com.bank.service.helpers.ImageUtils;
import com.bank.service.helpers.RegistrationRequest;
import com.bank.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RequestMapping
@RestController
@RequiredArgsConstructor

public class ClientController {

    private final ClientService clientService;
    private final RegistrationService registrationService;
    private final ClientRepo clientRepo;

    @GetMapping("/registration/clients")
    public ResponseEntity<List<Client>> getClients(){
        return Optional
                .ofNullable( clientService.getClients() )
                .map(clients -> ResponseEntity.ok().body(clients))          //200 OK
                .orElseGet( () -> ResponseEntity.notFound().build() );  //404 Not found
    }



    @PostMapping("/registration/client")
    public String register(@RequestBody RegistrationRequest request){
        return registrationService.register(request);
    }




   /* public String uploadImage(MultipartFile image) throws IOException {
       Client clientImage = clientRepo.save(Client.builder().image(ImageUtils.compressImage(image.getBytes())).build());
       if(clientImage != null){
           return "file uploadeddddddd "+image.getOriginalFilename();
       }
    return null;
    }

    */
}
