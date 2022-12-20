package com.bank.service;

import com.bank.model.C_Professionnel;
import com.bank.model.C_Standard;
import com.bank.repository.C_StandardRepo;
import com.bank.repository.C_professionnelRepo;
import com.bank.repository.ClientRepo;
import com.bank.service.helpers.CompteRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional

public class C_ProfessionnelServiceImpl implements CompteService{
    private final C_professionnelRepo c_professionnelRepo;

   // private final C_Professionnel c_professionnel;

    public String addCompteByClient(C_Professionnel professionnel) throws Exception {

        c_professionnelRepo.save(professionnel);
        log.info("an account is adding by {} ", professionnel.getClient().getUsername());
        return "the account is added successfully";
    }

    public String saveAccount(CompteRequest request) throws Exception {
      /*  boolean ClientExists = c_standardRepo.findClientById(request.getClient_id().getId()).isPresent();
        if(!ClientExists){
            throw new Exception("this id client "+request.getClient_id().getId()+" not found !!!!!");
        }

       */
        if(request.getType().equalsIgnoreCase("Professionnel")){
            try {

                addCompteByClient(
                        new C_Professionnel(request.getType(), request.getClient_id(), request.getAgent_id())
                );
                // clientRepo.updateCompte(request.getClient_id().getId(),new C_Standard(request.getId(), request.getType(), request.getAmount(), request.getClient_id(), request.getAgent_id()));

                return "it has saved successfully & agent id = "+request.getClient_id();
            }catch (Exception ex){
                throw new Exception(ex.getMessage());
            }

        } else {
            return "check the type of the account must be Professionnel";
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


    public C_Professionnel getCStandardById(Long id){
        return c_professionnelRepo.findById(id).orElse(null);
    }

    public C_Professionnel updateCStandard(C_Standard c_standard){
        C_Professionnel existsProfessionnel = c_professionnelRepo.findById(c_standard.getId()).orElse(null);
        existsProfessionnel.setEnable(true);
        return c_professionnelRepo.save(existsProfessionnel);
    }

}
