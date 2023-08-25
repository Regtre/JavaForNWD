package fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.exchange;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum NWDExchangeRuntimeKind implements Serializable {
//    None(NWDExchangeKind.None.getValue()),
//    Test(NWDExchangeKind.Test.getValue()),
//    Unknown(NWDExchangeKind.Unknown.getValue()),

    @SerializedName("-9")
    None(-9),
    @SerializedName("-1")
    Test(-1),
    @SerializedName("0")
    Unknown(0),
    @SerializedName("2")
    AccountDelete(2),
    @SerializedName("3")
    AccountChangeRange(3),
    @SerializedName("10")
    SignOut(10),
    @SerializedName("11")
    SignIn(11),
    @SerializedName("12")
    SignUp(12),

    @SerializedName("13")
    SignLost(13),
    @SerializedName("14")
    SignAdd(14),
    @SerializedName("15")
    SignModify(15),
    @SerializedName("16")
    SignDelete(16),

    @SerializedName("17")
    GetAllSign(17),
    @SerializedName("18")
    SignRescue(18),

    @SerializedName("21")
    SyncDataByIncrement(21),
    @SerializedName("22")
    GetAllData(22),
    @SerializedName("31")
    GetAllPlayerData(31),
    @SerializedName("32")
    GetPlayerDataByReferences(32),
    @SerializedName("33")
    GetPlayerDataByBundle(33),
    @SerializedName("41")
    GetAllStudioData(41),
    @SerializedName("42")
    GetStudioDataByReferences(42),
    @SerializedName("43")
    GetStudioDataByBundle(43),
    @SerializedName("50")
    CreateRelationship(50),
    @SerializedName("51")
    LinkRelationship(51),
    @SerializedName("52")
    FinalizeRelationship(52),
    @SerializedName("53")
    GetRelationship(53);
    private final int value;

    @JsonCreator
    NWDExchangeRuntimeKind( int value) {
        this.value = value;
    }

    @JsonCreator
    public static NWDExchangeRuntimeKind forValues( int value) {
        for (NWDExchangeRuntimeKind nwdExchangeRuntimeKind : NWDExchangeRuntimeKind.values()) {
            if (nwdExchangeRuntimeKind.value == value) {
                return nwdExchangeRuntimeKind;
            }
        }
        return null;
    }

    @JsonValue
    public int getValue() {
        return value;
    }
}