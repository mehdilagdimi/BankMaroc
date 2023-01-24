package com.bank.service.helpers;

import com.bank.model.UserRole;
import lombok.*;

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
    private final byte[] image;
    private final String telephone;

}
