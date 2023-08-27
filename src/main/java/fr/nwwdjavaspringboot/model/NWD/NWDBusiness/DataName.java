package fr.nwwdjavaspringboot.model.NWD.NWDBusiness;

import java.io.Serializable;

public class DataName implements Serializable {
    public String name;
    public DataName(String name) {
        this.name = name;
    }

    public DataName() {
    }
}
