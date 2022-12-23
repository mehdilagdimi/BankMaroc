package com.bank.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class C_Professionnel extends Compte {

    @OneToMany(mappedBy = "c_professionnel")
    @JsonIgnore
    private List<Carte> professionnelCartes;

    public C_Professionnel( String type,Client client_id, Agent agent, Long numC) {
        super(type, client_id, agent, numC);
    }

    public C_Professionnel( Long id,String type, Client client_id, Agent agent_id) {
        super(id, type, client_id, agent_id);
    }
}
