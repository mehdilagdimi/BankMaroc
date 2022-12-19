package com.bank.controller;

import com.bank.service.C_StandardServiceImpl;
import com.bank.service.helpers.CompteRequest;
import com.bank.service.helpers.RegistrationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
@RequiredArgsConstructor
public class C_StandardController {
    private final C_StandardServiceImpl c_standardService;

    @PostMapping("/registration/addCompteStandard")
    public String addCompteStandard(@RequestBody CompteRequest request) throws Exception {
        return c_standardService.saveAccount(request);
    }

}


