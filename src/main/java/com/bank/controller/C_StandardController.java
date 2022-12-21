package com.bank.controller;

import com.bank.model.C_Standard;
import com.bank.model.Carte;
import com.bank.service.C_StandardServiceImpl;
import com.bank.service.CarteService;
import com.bank.service.helpers.CarteRequest;
import com.bank.service.helpers.CompteRequest;
import com.bank.service.helpers.RegistrationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping
@RestController
@RequiredArgsConstructor
public class C_StandardController {
    private final C_StandardServiceImpl c_standardService;
    private final CarteService carteService;

    @PostMapping("/registration/addCompteStandard")
    public String addCompteStandard(@RequestBody CompteRequest request) throws Exception {
        String compte = c_standardService.saveAccount(request);
        return compte ;
    }

    @PostMapping("/registration/addCarteVisa")
    public String addCarteVisa(@RequestBody CompteRequest request) throws Exception {
        return carteService.saveCarte(request);
    }

    @GetMapping("/registration/standard/{id}")
    public C_Standard findStandardById(@PathVariable Long id){
        return c_standardService.getCStandardById(id);
    }

     @PutMapping("/registration/updateCompteStandard")
    public C_Standard updateStandard(@RequestBody C_Standard c_standard){
        return c_standardService.updateCStandard(c_standard);
     }

}


