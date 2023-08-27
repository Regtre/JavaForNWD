package fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges;

import com.fasterxml.jackson.annotation.JsonValue;
import com.google.gson.annotations.SerializedName;

public enum NWDPlayerDataProcessKind {

    @SerializedName("0")
    None(0),

    /// <summary>
    /// One one row authorized
    /// </summary>
    @SerializedName("1")
    OnlyOneData( 1),

    /// <summary>
    /// Only unique Field One on all range
    /// </summary>
    @SerializedName("2")
    UniqueFieldOne( 2),

    /// <summary>
    /// Only unique Field Two on all range for the Field One  (example : {Sam, 12} , {Sam, 13} , {John, 12}  ...)
    /// </summary>
    @SerializedName("3")
    UniqueNickname( 3),

    /// <summary>
    /// Use to find object to share objects ... not really define ( see Barter, Trader, MacthMaking)
    /// </summary>
    @SerializedName("9")
    Finder(9);

    private final int i;

    NWDPlayerDataProcessKind(int i) {
        this.i = i;
    }

    @JsonValue
    public int getI() {
        return i;
    }
}
