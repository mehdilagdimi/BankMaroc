package com.bank.service;

import com.bank.model.C_Professionnel;
import com.bank.model.C_Standard;
import com.bank.model.Carte;
import com.bank.model.Compte;
import com.bank.repository.C_StandardRepo;
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
    private final C_StandardRepo c_StandardRepo;
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

    public String faireAchat(Carte carte){
        // comparer entre la val entree et le plateforme ==> l'amount deminuer
        Carte existsCarte = carteRepo.findById(carte.getId()).orElse(null);
        C_Standard existsStandard =  c_StandardRepo.findById(carte.getId()).orElse(null);
        if(existsCarte.getAchatQ() > carte.getAchatQ()){
            //update amount du compte
            existsStandard.setAmount(existsStandard.getAmount()- carte.getAchatQ());
            c_StandardRepo.save(existsStandard);
            return "vous pouvez faire l'achat car vous n'avez pas depassé la plateforme quotidienne et le montant "+
                    " est devenu == " +existsStandard.getAmount();
        }
        else {
            return "vous ne pouvez pas faire l'achat car vous avez depassé la plateforme quotidienne associé à une carte de type "+carte.getCarte_type();
        }
    }

}
