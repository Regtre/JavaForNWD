package fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.exchange;

import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

public enum NWDExchangeDevice implements Serializable {
    Unknown(0),
    Ios(11),
    Android(12),
    Macos(21),
    Windows(22),
    Linux(23),
    Web(41),
    Error(128);

    private final int value;

    NWDExchangeDevice(int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return value;
    }
}
