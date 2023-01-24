package com.bank.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public abstract class Compte {
    @Id
    @SequenceGenerator(name = "compte_sequence", sequenceName = "compte_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "compte_sequence")
    private Long id;
    private Boolean enable = false;
    private String type;
    private Long amount = Long.valueOf(0);
    @Column(length = 24)
    private Long numC;

    @ManyToOne
    private Agent agent;


    @OneToOne(fetch = FetchType.EAGER)
    private Client client;

    public Compte(String type,  Client client, Agent agent, Long numC) {
        this.type = type;
        this.client = client;
        this.agent = agent;
        this.numC = numC;
    }

    public Compte(Long id, String type, Client client, Agent agent) {
        this.id = id;
        this.type = type;
        this.client = client;
        this.agent = agent;
    }


}
