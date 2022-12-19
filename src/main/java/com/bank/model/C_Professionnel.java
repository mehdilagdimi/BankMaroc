package com.bank.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class C_Professionnel extends Compte {

    private Long numPremiunCarte;
    private Long numIntCarte;

    public C_Professionnel( String type, Long amount,Client client_id) {
        super(type,amount, client_id);
    }
}
