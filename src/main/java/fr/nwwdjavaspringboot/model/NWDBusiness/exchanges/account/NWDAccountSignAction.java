package fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.account;

import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

public enum NWDAccountSignAction implements Serializable {

    None(0), // NEVER CHANGE INT VALUE !!!
    TryToAssociate(10), // NEVER CHANGE INT VALUE !!!
    Associated(11), // NEVER CHANGE INT VALUE !!!
    ErrorAssociated(12), // NEVER CHANGE INT VALUE !!!
    TryToDissociate(20), // NEVER CHANGE INT VALUE !!!
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
