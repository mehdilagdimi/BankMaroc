package com.bank.service;

import com.bank.model.Agent;
import com.bank.model.Client;
import com.bank.service.helpers.EmailValidator;
import com.bank.service.helpers.RegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {
    private final EmailValidator emailValidator;
    private AgentServiceImpl agentService;
    private ClientServiceImpl clientService;
    public String register(RegistrationRequest request){
        boolean isValidUsername = emailValidator.test(request.getUsername());
        if(!isValidUsername){
            throw new IllegalStateException("username not valid !");
        }
        if(request.getUserRole().name().equals("AGENT")) {
            return agentService.signUpUser(
                    new Agent(request.getUsername(), request.getEmail(), request.getPassword(), request.getUserRole())
            );
        } else if(request.getUserRole().name().equals("CLIENT")){

            return clientService.signUpClient(
                    new Client(request.getUsername(), request.getEmail(), request.getPassword(), request.getUserRole(), request.getCIN(), request.getImage(), request.getTelephone())
            );
        }
        return request.getUserRole().name();
    }
}
