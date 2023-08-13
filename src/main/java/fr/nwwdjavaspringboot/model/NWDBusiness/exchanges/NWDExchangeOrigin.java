package fr.nwwdjavaspringboot.model.NWDBusiness.exchanges;

import java.io.Serializable;

public enum NWDExchangeOrigin implements Serializable {
    Unknown(0),
    Game(1),
    App(2),
    Web(4),
    UnityEditor(8);

    private final int value;

    NWDExchangeOrigin(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}