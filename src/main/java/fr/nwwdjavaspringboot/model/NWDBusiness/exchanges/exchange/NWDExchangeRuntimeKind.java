package fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.exchange;

import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

public enum NWDExchangeRuntimeKind implements Serializable {
//    None(NWDExchangeKind.None.getValue()),
//    Test(NWDExchangeKind.Test.getValue()),
//    Unknown(NWDExchangeKind.Unknown.getValue()),

    None(-9),
    Test(-1),
    Unknown(0),
    AccountDelete(2),
    AccountChangeRange(3),
    SignOut(10),
    SignIn(11),
    SignUp(12),
    SignLost(13),
    SignAdd(14),
    SignModify(15),
    SignDelete(16),

    GetAllSign(17),
    SignRescue(18),
    GetAllData(22),
    GetAllPlayerData(31),
    GetPlayerDataByReferences(32),
    GetPlayerDataByBundle(33),
    GetAllStudioData(41),
    GetStudioDataByReferences(42),
    GetStudioDataByBundle(43),
    CreateRelationship(50),
    LinkRelationship(51),
    FinalizeRelationship(52),
    GetRelationship(53);
    private final int value;

    NWDExchangeRuntimeKind(int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return value;
    }
}