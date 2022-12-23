package com.bank.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor

public class C_Standard extends  Compte{

    @OneToMany(mappedBy = "c_standard")
    @JsonIgnore
    private List<Carte> standardCartes;

    public C_Standard( String type,Client client_id, Agent agent_id, Long numC) {
        super(type, client_id, agent_id, numC);
    }

    public C_Standard( Long id,String type, Client client_id, Agent agent_id) {
        super(id, type, client_id, agent_id);
    }
}
