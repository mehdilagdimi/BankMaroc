package com.bank.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Client extends User {
    private String CIN;
    private String telephone;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Compte compte;


    public Client(String username, String email, String password, UserRole userRole, String CIN, String telephone) {
        super(username, email, password, userRole);
        this.CIN = CIN;
        this.telephone = telephone;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(getUserRole().name());
        return Collections.singletonList(simpleGrantedAuthority);
    }

}

