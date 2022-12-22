package com.bank.service.helpers;

import com.bank.model.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
@RequiredArgsConstructor
public class CompteRequest {

    private final Long id;
    private final boolean enable = false;
    private final Client client_id;
    private final String type;
    private final Agent agent_id;
    private final Long numC;

    //carte
    private final String carte_type;
    private final Long retraitQ;
    private final Long retraitA;
    private final Long achatQ;
    private final Long achatA;
    private final C_Standard c_standard;
    private final C_Professionnel c_professionnel;
}
