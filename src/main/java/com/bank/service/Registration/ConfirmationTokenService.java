package com.bank.service.Registration;

import com.bank.model.ConfirmationToken;
import com.bank.repository.ConfirmationTokenRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {

    private final ConfirmationTokenRepo confirmationTokenRepo;

    public void saveConfirmationToken(ConfirmationToken token){
        confirmationTokenRepo.save(token);
    }
}
