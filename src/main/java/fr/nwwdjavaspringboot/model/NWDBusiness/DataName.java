package fr.nwwdjavaspringboot.model.NWDBusiness;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class DataName implements Serializable {
    public String name;
    public DataName(String name) {
        this.name = name;
    }

    public DataName() {
    }
}
