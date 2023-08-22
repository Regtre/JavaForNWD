package fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.account;

import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

public enum NWDAccountSignType implements Serializable {
    None(0),
    DeviceId(1), // NEVER CHANGE INT VALUE !
    EmailPassword(10), // NEVER CHANGE INT VALUE !
    OldEmailPassword(75), // NEVER CHANGE INT VALUE !
    LoginEmailPassword(11), // NEVER CHANGE INT VALUE !
    LoginPassword(12), // NEVER CHANGE INT VALUE !
    Facebook(20), // NEVER CHANGE INT VALUE !
    Google(21), // NEVER CHANGE INT VALUE !
    Apple(22), // NEVER CHANGE INT VALUE !
    Microsoft(23), // NEVER CHANGE INT VALUE !
    Twitter(24), // NEVER CHANGE INT VALUE !
    LinkedIn(25), // NEVER CHANGE INT VALUE !
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