package com.bank.service;

import com.bank.model.Agent;
import com.bank.model.C_Professionnel;
import com.bank.model.C_Standard;
import com.bank.model.Compte;
import com.bank.repository.AgentRepo;
import com.bank.repository.C_StandardRepo;
import com.bank.repository.ClientRepo;
import com.bank.service.helpers.CompteRequest;
import com.bank.service.helpers.RegistrationRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional

public class C_StandardServiceImpl implements CompteService{
    private final C_StandardRepo c_standardRepo;

    public String addCompteByClient(C_Standard standard) throws Exception {

        c_standardRepo.save(standard);
        log.info("an account is adding by {} ", standard.getClient().getUsername());
        return "the account is added successfully";
    }

    public String saveAccount(CompteRequest request) throws Exception {
      /*  boolean ClientExists = c_standardRepo.findClientById(request.getClient_id().getId()).isPresent();
        if(!ClientExists){
            throw new Exception("this id client "+request.getClient_id().getId()+" not found !!!!!");
        }

       */
        if(request.getType().equalsIgnoreCase("Standard")){
            try {
            addCompteByClient(
                    new C_Standard(request.getType(), request.getAmount(), request.getClient_id())
            );
            return "it has saved successfully ";
            }catch (Exception ex){
                throw new Exception("something wrong in add .............");
            }

        } else {
            return "check the type of the account must be Standard";
        }
    }

    @Override
    public Double depot(Double amount) {
        return null;
    }

    @Override
    public Double Retrait(Double amount) {
        return null;
    }
}
