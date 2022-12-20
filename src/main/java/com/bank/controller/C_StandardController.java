package com.bank.controller;

import com.bank.model.C_Standard;
import com.bank.service.C_StandardServiceImpl;
import com.bank.service.helpers.CompteRequest;
import com.bank.service.helpers.RegistrationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping
@RestController
@RequiredArgsConstructor
public class C_StandardController {
    private final C_StandardServiceImpl c_standardService;

    @PostMapping("/registration/addCompteStandard")
    public String addCompteStandard(@RequestBody CompteRequest request) throws Exception {
        return c_standardService.saveAccount(request);
    }

    @GetMapping("/registration/standard/{id}")
    public C_Standard findStandardById(@PathVariable Long id){
        return c_standardService.getCStandardById(id);
    }

     @PutMapping("/registration/updateCompte")
    public C_Standard updateStandard(@RequestBody C_Standard c_standard){
        return c_standardService.updateCStandard(c_standard);
     }

}


