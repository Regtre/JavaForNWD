package fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.exchange;

import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

public enum NWDExchangeKind implements Serializable {
    None(-9),
    Test(-1),
    Unknown(0);

    private final int value;

    NWDExchangeKind(int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return value;
    }
}