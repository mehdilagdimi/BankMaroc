package com.bank.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Carte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String carte_type = "GAB Visa";
    private Long amount;
    private Long retraitQ = Long.valueOf(5000);
    private Long retraitA = Long.valueOf(100000);
    private Long achatQ = Long.valueOf(5000);
    private Long achatA = Long.valueOf(10000);

    @ManyToOne
    private Compte compte;


    public Carte(String carte_type, Long amount, Compte compte_id) {
        this.carte_type = carte_type;
        this.amount = amount;
        this.compte = compte_id;
    }
}
