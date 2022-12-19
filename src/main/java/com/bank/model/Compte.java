package com.bank.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private Long amount;

    @ManyToOne
    private Agent agent;

    @OneToOne(fetch = FetchType.EAGER)
    private Client client;

    public Compte(String type, Long amount, Client client) {
        this.type = type;
        this.amount = amount;
        this.client = client;
    }
}
