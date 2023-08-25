package fr.nwwdjavaspringboot.model.NWDBusiness;

import com.fasterxml.jackson.annotation.JsonValue;
import com.google.gson.annotations.SerializedName;

public enum NWDAccountServiceStatus {

    @SerializedName("0")
    IsInactive(0),

    @SerializedName("1")
    IsActive(1),

    //waiting activation and then add duration to now
    @SerializedName("3")
    IsWaitingActivation(3),

    // Alert user ...
    @SerializedName("9")
    IsBan(9),

    // copy this service as subservice and stay as subservice ( to reatribue later)
    @SerializedName("88")
    IsSubServiced(88),

    // copy as original and desactive this service
    @SerializedName("99")
    IsToTranfert(99);

    private final int i;

    NWDAccountServiceStatus(int i) {
        this.i = i;
    }

    @JsonValue
    public int getI() {
        return i;
    }
}
