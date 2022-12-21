package com.bank.controller;

import com.bank.model.C_Professionnel;
import com.bank.model.C_Standard;
import com.bank.service.C_ProfessionnelServiceImpl;
import com.bank.service.C_StandardServiceImpl;
import com.bank.service.helpers.CompteRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping
@RestController
@RequiredArgsConstructor

public class C_ProfessionnelController {
    private final C_ProfessionnelServiceImpl c_professionnelService;

    @PostMapping("/registration/addCompteProfessionnel")
    public String addCompteProfessionnel(@RequestBody CompteRequest request) throws Exception {
        return c_professionnelService.saveAccount(request);
    }

    @PutMapping("/registration/updateCompteProfessionnel")
    public C_Professionnel updateProfessionnel(@RequestBody C_Professionnel c_professionnel){
        return c_professionnelService.updateCProfessionnel(c_professionnel);
    }
}
