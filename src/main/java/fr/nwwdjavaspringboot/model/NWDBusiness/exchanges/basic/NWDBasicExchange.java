package fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.basic;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import fr.nwwdjavaspringboot.model.NWDBusiness.NWDEnvironmentKind;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigInteger;

@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public abstract class NWDBasicExchange implements Serializable {
//    public String Dll = NWDVersionDll.Version;
//    public String IdName  = NWDRandom.RandomString(8);
    public BigInteger projectId;
    public NWDEnvironmentKind environment;
    public String stamp;
    public String hash;

    public String payload;
    public int timestamp;

}
