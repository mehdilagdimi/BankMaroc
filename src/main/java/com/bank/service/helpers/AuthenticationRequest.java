package com.bank.service.helpers;

import com.bank.model.UserRole;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@RequiredArgsConstructor
public class AuthenticationRequest {
    private final String email;
    private final String password;
    private final String userRole;
}
