package com.bank.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Entity
@AllArgsConstructor
public class C_Professionnel extends Compte {

    public C_Professionnel( String type,Client client_id, Agent agent, Long numC) {
        super(type, client_id, agent, numC);
    }

    public C_Professionnel( Long id,String type, Client client_id, Agent agent_id) {
        super(id, type, client_id, agent_id);
    }
}
