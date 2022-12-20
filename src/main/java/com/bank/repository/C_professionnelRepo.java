package com.bank.repository;

import com.bank.model.C_Professionnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)

public interface C_professionnelRepo extends JpaRepository<C_Professionnel, Long> {
}
