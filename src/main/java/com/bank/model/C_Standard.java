package com.bank.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor

public class C_Standard extends  Compte{


    public C_Standard( String type, Long amount,Client client_id) {
        super(type,amount, client_id);
    }
}
