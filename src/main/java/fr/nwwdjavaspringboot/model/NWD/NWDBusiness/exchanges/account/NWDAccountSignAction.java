package fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.account;

import com.fasterxml.jackson.annotation.JsonValue;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public enum NWDAccountSignAction implements Serializable {

    @SerializedName("0")
    None(0), // NEVER CHANGE INT VALUE !!!
    @SerializedName("10")
    TryToAssociate(10), // NEVER CHANGE INT VALUE !!!
    @SerializedName("11")
    Associated(11), // NEVER CHANGE INT VALUE !!!
    @SerializedName("12")
    ErrorAssociated(12), // NEVER CHANGE INT VALUE !!!
    @SerializedName("20")
    TryToDissociate(20), // NEVER CHANGE INT VALUE !!!
    @SerializedName("21")
    Dissociated(21);

    private final int value;

    NWDAccountSignAction(int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return value;
    }
    }
