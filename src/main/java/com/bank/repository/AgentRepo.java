package com.bank.repository;

import com.bank.model.Agent;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface AgentRepo extends JpaRepository<Agent, Long> {
    Optional<Agent> findByUsername(String username);
    Optional<Agent> findByEmail(String Email);
}
