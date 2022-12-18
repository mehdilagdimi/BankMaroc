package com.bank.service;

import com.bank.model.UserRole;
import lombok.*;
import org.springframework.context.annotation.Bean;

@Getter
@EqualsAndHashCode
@ToString
@RequiredArgsConstructor
public class RegistrationRequest {
    private final String username;
    private final String email;
    private final String password;
    private final UserRole userRole;
    private final String CIN;
    private final String telephone;
}
