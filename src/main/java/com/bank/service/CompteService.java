package com.bank.service;

import com.bank.model.C_Standard;
import com.bank.model.Compte;
import com.bank.service.helpers.CompteRequest;

public interface CompteService {

   Double depot(Double amount);

   Double Retrait(Double amount);

}
