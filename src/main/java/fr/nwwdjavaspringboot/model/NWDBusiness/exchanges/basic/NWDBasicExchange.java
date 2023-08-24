package fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.basic;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import fr.nwwdjavaspringboot.model.NWDBusiness.NWDEnvironmentKind;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public abstract class NWDBasicExchange implements Serializable {
//    public String Dll = NWDVersionDll.Version;
//    public String IdName  = NWDRandom.RandomString(8);
    public long projectId;
    public NWDEnvironmentKind environment;
    public String stamp;
    public String hash;

    public String payload;
    public int timestamp;

}
