package fr.nwwdjavaspringboot.model.NWDBusiness.exchanges;

import java.io.Serializable;

public enum NWDExchangeRuntimeKind implements Serializable {
    None(NWDExchangeKind.None.getValue()),
    Test(NWDExchangeKind.Test.getValue()),
    Unknown(NWDExchangeKind.Unknown.getValue()),
    AccountDelete(2),
    AccountChangeRange(3),
    SignOut(10),
    SignIn(11),
    SignUp(12),
    SignLost(13),
    SignAdd(14),
    SignModify(15),
    SignDelete(16),
    GetAllSign;

    private int value;

    private NWDExchangeRuntimeKind() {}

    private NWDExchangeRuntimeKind(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}