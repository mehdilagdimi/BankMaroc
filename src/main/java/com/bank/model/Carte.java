package com.bank.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String carte_type;
    private Long retraitQ = Long.valueOf(5000);
    private Long retraitA = Long.valueOf(100000);
    private Long achatQ = Long.valueOf(5000);
    private Long achatA = Long.valueOf(10000);

    @ManyToOne
    @JsonIgnore
    private C_Professionnel c_professionnel;

    @ManyToOne
    @JsonIgnore
    private C_Standard c_standard;

    public Carte(String carte_type, C_Standard c_standard) {
        this.carte_type = carte_type;
        this.c_standard = c_standard;
    }

    public Carte(String carte_type, C_Professionnel c_professionnel) {
        this.carte_type = carte_type;
        this.c_professionnel = c_professionnel;
    }

    public Carte(String carte_type, C_Professionnel c_professionnel, Long achatA, Long achatQ, Long retraitA, Long retraitQ) {
        this.carte_type = carte_type;
        this.c_professionnel = c_professionnel;
        this.achatA = achatA;
        this.achatQ = achatQ;
        this.retraitA = retraitA;
        this.retraitQ = retraitQ;
    }
}
