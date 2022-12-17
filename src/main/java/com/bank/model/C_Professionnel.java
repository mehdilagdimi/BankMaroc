package com.bank.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class C_Professionnel extends Compte {

    private Long numPremiunCarte;
    private Long numIntCarte;
}
