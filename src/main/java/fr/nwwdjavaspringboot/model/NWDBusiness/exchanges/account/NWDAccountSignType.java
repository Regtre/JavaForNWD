package fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.account;

import com.fasterxml.jackson.annotation.JsonValue;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public enum NWDAccountSignType implements Serializable {
    @SerializedName("0")
    None(0),
    @SerializedName("1")
    DeviceId(1), // NEVER CHANGE INT VALUE !
    @SerializedName("10")
    EmailPassword(10), // NEVER CHANGE INT VALUE !
    @SerializedName("75")
    OldEmailPassword(75), // NEVER CHANGE INT VALUE !
    @SerializedName("11")
    LoginEmailPassword(11), // NEVER CHANGE INT VALUE !
    @SerializedName("12")
    LoginPassword(12), // NEVER CHANGE INT VALUE !
    @SerializedName("20")
    Facebook(20), // NEVER CHANGE INT VALUE !
    @SerializedName("21")
    Google(21), // NEVER CHANGE INT VALUE !
    @SerializedName("22")
    Apple(22), // NEVER CHANGE INT VALUE !
    @SerializedName("23")
    Microsoft(23), // NEVER CHANGE INT VALUE !
    @SerializedName("24")
    Twitter(24), // NEVER CHANGE INT VALUE !
    @SerializedName("25")
    LinkedIn(25), // NEVER CHANGE INT VALUE !
    @SerializedName("30")
    Discord(30); // NEVER CHANGE INT VALUE !

    private final int value;

    NWDAccountSignType(int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return value;
    }
}