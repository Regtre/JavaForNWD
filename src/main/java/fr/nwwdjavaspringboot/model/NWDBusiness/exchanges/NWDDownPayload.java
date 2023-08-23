package fr.nwwdjavaspringboot.model.NWDBusiness.exchanges;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.nwwdjavaspringboot.model.NWDBusiness.NWDAccountService;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class NWDDownPayload implements Serializable  {

    @JsonProperty("AccountServiceList")
    public List<NWDAccountService> AccountServiceList = new ArrayList<NWDAccountService>();;

}
