package fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.exchange;

import com.fasterxml.jackson.annotation.JsonValue;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public enum NWDExchangeOrigin implements Serializable {
    @SerializedName("0")
    Unknown(0),
    @SerializedName("1")
    Game(1),
    @SerializedName("2")
    App(2),
    @SerializedName("3")
    Web(4),
    @SerializedName("8")
    UnityEditor(8);

    private final int value;

    NWDExchangeOrigin(int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return value;
    }
}