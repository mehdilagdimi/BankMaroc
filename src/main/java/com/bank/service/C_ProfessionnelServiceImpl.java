package com.bank.service;

import com.bank.model.C_Standard;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional

public class C_ProfessionnelServiceImpl implements CompteService{

    @Override
    public Double depot(Double amount) {
        return null;
    }

    @Override
    public Double Retrait(Double amount) {
        return null;
    }


}
