package fr.nwwdjavaspringboot.model.NWDBusiness;

import com.fasterxml.jackson.annotation.JsonValue;

public enum NWDAccountServiceStatus {

    IsInactive(0),

    IsActive(1),

    //waiting activation and then add duration to now
    IsWaitingActivation(3),

    // Alert user ...
    IsBan(9),

    // copy this service as subservice and stay as subservice ( to reatribue later)
    IsSubServiced(88),

    // copy as original and desactive this service
    IsToTranfert(99),
    ;

    private final int i;

    NWDAccountServiceStatus(int i) {
        this.i = i;
    }

    @JsonValue
    public int getI() {
        return i;
    }
}
