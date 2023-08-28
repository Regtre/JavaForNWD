package fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.NWDAccountService;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class NWDDownPayload implements Serializable  {

    @SerializedName("AccountServicesList")
    public List<NWDAccountService> accountServicesList = new ArrayList<NWDAccountService>();
    public NWDDownPayload(){}

}
