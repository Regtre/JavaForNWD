package fr.nwwdjavaspringboot.model.NWDBusiness.exchanges;

import java.io.Serializable;

public enum NWDExchangeKind implements Serializable {
    None(-9),
    Test(-1),
    Unknown(0);

    private final int value;

    NWDExchangeKind(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}