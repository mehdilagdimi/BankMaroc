package com.bank.repository;

import com.bank.model.Agent;
import com.bank.model.Client;
import com.bank.model.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface ClientRepo extends JpaRepository<Client, Long> {
    Optional<Client> findByUsername(String username);
    Optional<Client> findByEmail(String email);

    @Modifying
    @Query("update Client c set c.compte = :compte where c.id = :id")
    void updateCompte(@Param(value = "id") long id, @Param(value = "compte") Compte compte);

}
