package fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.basic;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.nwwdjavaspringboot.model.NWDBusiness.NWDEnvironmentKind;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public abstract class NWDBasicExchange implements Serializable {
//    public String Dll = NWDVersionDll.Version;
//    public String IdName  = NWDRandom.RandomString(8);
    public long ProjectId;
    public NWDEnvironmentKind Environment ;
    public String Stamp;
    public String Hash;

    @JsonProperty("payload")
    public String Payload;
    public int Timestamp;

}
