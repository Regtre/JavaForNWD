package fr.nwwdjavaspringboot.model.NWDBusiness;


import java.io.Serializable;

public enum NWDEnvironmentKind implements Serializable {
    Dev(0),
    PlayTest(1),
    Qualification(2),
    PreProduction(3),
    Production(4),
    PostProduction(5);

    private final int value;

    NWDEnvironmentKind(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
