package fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;


@JsonIgnoreProperties(ignoreUnknown = true)
public class NWDDownPayload implements Serializable  {


    /*@JsonProperty("AccountServiceList")
    public List<NWDAccountService> AccountServiceList = new ArrayList<NWDAccountService>();;*/
    public NWDDownPayload(){}

}
