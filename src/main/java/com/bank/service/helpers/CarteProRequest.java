package com.bank.service.helpers;

import com.bank.model.C_Professionnel;
import com.bank.model.C_Standard;
import lombok.*;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@RequiredArgsConstructor
public class CarteProRequest {

    //carte
    private final String carte_type;
    private final Long retraitQ = Long.valueOf(10000);
    private final Long retraitA = Long.valueOf(200000);
    private final Long achatQ = Long.valueOf(15000);
    private final Long achatA= Long.valueOf(15000);
    private final C_Professionnel c_professionnel;

}
