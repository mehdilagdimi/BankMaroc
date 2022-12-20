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
    private String type;
    private Long amount;
    private Long retraitQ;
    private Long retraitA;
    private Long AchatQ;
    private Long AchatA;

    @ManyToOne
    private Compte compte;
}
