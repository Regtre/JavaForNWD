package fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges;

import com.fasterxml.jackson.annotation.JsonValue;
import com.google.gson.annotations.SerializedName;

public enum NWDAccountServiceKind {

    @SerializedName("0")
    Original(0),
    @SerializedName("1")
    Granted(1),
    @SerializedName("2")
    Transferred(2);

    private final int value;

    NWDAccountServiceKind(int i) {
        this.value = i;
    }

    @JsonValue
    public int getValue() {
        return value;
    }
}
