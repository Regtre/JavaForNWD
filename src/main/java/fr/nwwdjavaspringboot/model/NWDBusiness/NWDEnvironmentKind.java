package fr.nwwdjavaspringboot.model.NWDBusiness;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum NWDEnvironmentKind implements Serializable {

    @JsonProperty("Dev")
    Dev(0),
    @JsonProperty("PlayTest")
    PlayTest(1),
    @JsonProperty("Qualification")
    Qualification(2),
    @JsonProperty("PreProduction")
    PreProduction(3),
    @JsonProperty("Production")
    Production(4),
    @JsonProperty("PostProduction")
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
