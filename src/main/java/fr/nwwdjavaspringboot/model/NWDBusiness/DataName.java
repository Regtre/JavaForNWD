package fr.nwwdjavaspringboot.model.NWDBusiness;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DataName {
    @JsonProperty("name")
    public String name;
    public DataName(String name) {
        this.name = name;
    }
}
