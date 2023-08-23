package fr.nwwdjavaspringboot.model.NWDBusiness.exchanges;

import com.fasterxml.jackson.annotation.JsonValue;

public enum NWDPlayerDataProcessKind {

    None(0),

    /// <summary>
    /// One one row authorized
    /// </summary>
    OnlyOneData( 1),

    /// <summary>
    /// Only unique Field One on all range
    /// </summary>
    UniqueFieldOne( 2),

    /// <summary>
    /// Only unique Field Two on all range for the Field One  (example : {Sam, 12} , {Sam, 13} , {John, 12}  ...)
    /// </summary>
    UniqueNickname( 3),

    /// <summary>
    /// Use to find object to share objects ... not really define ( see Barter, Trader, MacthMaking)
    /// </summary>
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
