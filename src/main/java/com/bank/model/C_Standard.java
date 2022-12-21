package com.bank.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor

public class C_Standard extends  Compte{


    public C_Standard( String type,Client client_id, Agent agent_id, Long numC) {
        super(type, client_id, agent_id, numC);
    }

    public C_Standard( Long id,String type, Client client_id, Agent agent_id) {
        super(id, type, client_id, agent_id);
    }
}
