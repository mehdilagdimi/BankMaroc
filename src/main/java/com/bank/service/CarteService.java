package com.bank.service;

import com.bank.model.C_Professionnel;
import com.bank.model.C_Standard;
import com.bank.model.Carte;
import com.bank.model.Compte;
import com.bank.repository.C_professionnelRepo;
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
    private final C_professionnelRepo c_professionnelRepo;
    public String addCarte(Carte carte){
        carteRepo.save(carte);
        log.info("a carte {} ", carte.getId() +" was added");
        return "added";
    }

    public String saveCarteVisa(CompteRequest request) throws Exception {

        if(request.getCarte_type().equalsIgnoreCase("GAB Visa")){
            try {
                addCarte(
                        new Carte(request.getCarte_type(), request.getC_standard())
                );
                return "the carte has saved successfully of the account type ===> "+request.getC_standard()+"\n carte: "+request.getCarte_type();
            }catch (Exception ex){
                throw new Exception(ex.getMessage());
            }
        }
        else {
            return "check the type of the carte must be GAB Visa";
        }
    }

    public String saveCartePremium(CompteRequest request) throws Exception {
        if(request.getCarte_type().equalsIgnoreCase("Premium")){
            try {
                addCarte(
                        new Carte(request.getCarte_type(), request.getC_professionnel(), request.getAchatA(), request.getAchatQ(), request.getRetraitA(), request.getRetraitQ())
                );
                return "the carte has saved successfully of the account type ===> "+request.getAchatQ()+"\n carte: "+request.getCarte_type();
            }catch (Exception ex){
                throw new Exception(ex.getMessage());
            }
        }
        else {
            return "check the type of the carte must be GAB Visa";
        }
    }

   /*     public String saveCartepremium(Carte carte){
            carte.setCompte(isCompteExists(.getCompte()));
            carte.setCarte_type(request.getCarte_type());
            carte.setAchatA(Long.valueOf(15000));
            carte.setRetraitQ(Long.valueOf(10000));
            carte.setRetraitA(Long.valueOf(200000));
            carte.setAchatQ(Long.valueOf(15000));
            carteRepo.save(carte);
        }

    */

}
