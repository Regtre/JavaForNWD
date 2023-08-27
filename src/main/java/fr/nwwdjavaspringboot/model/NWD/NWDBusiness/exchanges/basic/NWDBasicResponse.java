package fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.basic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.request.NWDRequestStatus;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public abstract class NWDBasicResponse extends NWDBasicExchange implements Serializable {
    public NWDRequestStatus status = NWDRequestStatus.None;
    public String serverIdentity;
    public String Debug;
}

