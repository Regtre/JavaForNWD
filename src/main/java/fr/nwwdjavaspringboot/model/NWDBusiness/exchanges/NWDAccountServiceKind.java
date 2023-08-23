package fr.nwwdjavaspringboot.model.NWDBusiness.exchanges;

import com.fasterxml.jackson.annotation.JsonValue;

public enum NWDAccountServiceKind {

    Original(0),
    Granted(1),
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
