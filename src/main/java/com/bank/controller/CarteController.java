package com.bank.controller;

import com.bank.model.C_Professionnel;
import com.bank.model.Carte;
import com.bank.model.Compte;
import com.bank.service.CarteService;
import com.bank.service.helpers.CarteProRequest;
import com.bank.service.helpers.CompteRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
@RequiredArgsConstructor

public class CarteController {
    private final CarteService carteService;

    @PostMapping("/registration/addCartePremium")
    public String saveCartePremium(@RequestBody CarteProRequest compteRequest) throws Exception {
        return carteService.saveCartePremium(compteRequest);
    }

}
