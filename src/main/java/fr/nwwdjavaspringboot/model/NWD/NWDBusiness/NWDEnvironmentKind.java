package fr.nwwdjavaspringboot.model.NWD.NWDBusiness;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum NWDEnvironmentKind implements Serializable {

    @SerializedName("0")
    Dev(0),
    @SerializedName("1")
    PlayTest(1),
    @SerializedName("2")
    Qualification(2),
    @SerializedName("3")
    PreProduction(3),
    @SerializedName("4")
    Production(4),
    @SerializedName("5")
    PostProduction(5);

    private final int value;

    NWDEnvironmentKind(int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return value;
    }
}
