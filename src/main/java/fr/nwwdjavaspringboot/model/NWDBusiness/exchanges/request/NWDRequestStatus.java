package fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.request;

import com.fasterxml.jackson.annotation.JsonValue;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public enum NWDRequestStatus implements Serializable {
    /// <summary>
    /// Answer returned if Server is Disabled
    /// </summary>
    @SerializedName("-3")
    ServerIsDisabled(-3),
    /// <summary>
    /// Answer returned if Server is overflow
    /// </summary>

    @SerializedName("-2")
    PleaseChangeServer(-2),
    /// <summary>
    /// Just Test answer : ok or ko
    /// </summary>
    @SerializedName("-1")
    Test(-1),
    /// <summary>
    /// No Response
    /// </summary>
    @SerializedName("0")
    None(0),
    /// <summary>
    /// Answer Unknow
    /// </summary>
    @SerializedName("98")
    Unknown(98),
    /// <summary>
    /// Answer Error
    /// </summary>
    @SerializedName("99")
    Error(99),

    @SerializedName("1")
    Ok(1),

    @SerializedName("9")
    ProjectIsPublishing(9),

    @SerializedName("89")
    AccountUnknown(89),

    @SerializedName("90")
    AccountError(90),

    @SerializedName("91")
    AccountNotUnique(91),

    @SerializedName("12")
    AccountBan(12),

    @SerializedName("13")
    AccountTrashed(13),

    @SerializedName("700")
    NoNetwork(700),

    @SerializedName("800")
    DaoError(800),

    @SerializedName("900")
    TokenError(900),

    @SerializedName("901")
    HashInvalid(901),

    @SerializedName("902")
    TokenNull(902),

    @SerializedName("903")
    TokenEmpty(903);

    private final int i;

    NWDRequestStatus(int i) {
        this.i = i;
    }
    @JsonValue
    public int getI() {
        return i;
    }
}
