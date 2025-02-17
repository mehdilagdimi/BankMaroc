package com.bank.service;

import com.bank.model.C_Standard;
import com.bank.model.Carte;
import com.bank.repository.CarteRepo;
import com.bank.service.helpers.CarteRequest;
import com.bank.service.helpers.CompteRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class CarteService {
    private final CarteRepo carteRepo;
    public String addCarte(Carte carte){
        carteRepo.save(carte);
        log.info("a carte {} et de type {}", carte.getId(),carte.getCarte_type());
        return "adddddddddddddddddeeed";
    }

    public String saveCarte(CompteRequest request) throws Exception {

        if(request.getCarte_type().equalsIgnoreCase("GAB Visa")){
            try {
                addCarte(
                        new Carte(request.getCarte_type(),request.getAmount(), request.getCompte_id())
                );
                return "the carte has saved successfully & agent id = "+request.getCarte_type();
            }catch (Exception ex){
                throw new Exception(ex.getMessage());
            }
        } else {
            return "check the type of the carte must be GAB Visa";
        }
    }

}
