package com.bank.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Client extends User{
    private String CIN;
    private String telephone;

    @OneToOne
    private Compte compte;

    public Client(String username, String email, String password, UserRole userRole, String CIN, String telephone) {
        super(username, email, password, userRole);
        this.CIN = CIN;
        this.telephone = telephone;
    }
}
