package com.bank.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@NoArgsConstructor
@Entity
public class Agent extends User {


    @OneToMany(mappedBy = "agent")
    private List<Compte> comptes;

    public Agent(String username, String email, String password, UserRole userRole) {
        super(username, email, password, userRole);
    }


}
