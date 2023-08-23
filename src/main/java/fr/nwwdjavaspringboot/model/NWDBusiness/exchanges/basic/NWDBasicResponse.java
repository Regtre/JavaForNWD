package fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.basic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.request.NWDRequestStatus;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public abstract class NWDBasicResponse extends NWDBasicExchange implements Serializable {
    public NWDRequestStatus Status = NWDRequestStatus.None;
    public String ServerIdentity;
    public String Debug;
}

