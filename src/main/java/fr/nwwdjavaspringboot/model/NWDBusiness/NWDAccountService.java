package fr.nwwdjavaspringboot.model.NWDBusiness;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.NWDAccountServiceKind;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
public class NWDAccountService extends NWDAccountData implements Serializable {

    @JsonProperty("ServiceKind")
    public NWDAccountServiceKind ServiceKind = NWDAccountServiceKind.Original;
    @JsonProperty("EnvironmentKind")
    public NWDEnvironmentKind EnvironmentKind;
    @JsonProperty("Name")
    public String Name;
    @JsonProperty("Service")
    public long Service;
    @JsonProperty("OfferByAccount")
    public NWDReference<NWDAccount> OfferByAccount = new NWDReference<NWDAccount>();
    @JsonProperty("FromAccountService")
    public NWDReference<NWDAccountService> FromAccountService = new NWDReference<NWDAccountService>();

    @JsonProperty("ToAccount")
    public NWDReference<NWDAccount> ToAccount = new NWDReference<NWDAccount>();
    @JsonProperty("ToAccountService")
    public NWDReference<NWDAccountService> ToAccountService = new NWDReference<NWDAccountService>();

    @JsonProperty("MessageStyle")
    public NWDBootstrapKindOfStyle MessageStyle = NWDBootstrapKindOfStyle.Primary;
    @JsonProperty("Message")
    public String Message = ""; // use to show special message for this services


    @JsonProperty("Status")
    public NWDAccountServiceStatus Status = NWDAccountServiceStatus.IsInactive;
    @JsonProperty("Duration")
    public int Duration = 0;
    @JsonProperty("UniqueService")
    public boolean UniqueService = false;
    /// <summary>
    /// use to ovveride service by name ... if service with service number and name already exist => override it with this information
    /// </summary>
    @JsonProperty("OverrideByName")
    public boolean OverrideByName = false;

    @JsonProperty("Ip")
    public String Ip;
    @JsonProperty("Cookie")
    public String Cookie;
    @JsonProperty("OfflineCounterDown")
    public int OfflineCounterDown = 0;
    @JsonProperty("Start")
    public int Start = 0;
    @JsonProperty("End")
    public int End = 0;

    public NWDAccountService() {
    }

    public NWDAccountService(long sProjectId, NWDEnvironmentKind sEnvironmentKind, long sAccount, long sService, LocalDateTime sStart, LocalDateTime sEnd, String sMessage, NWDBootstrapKindOfStyle sMessageStyle) {
        projectId = sProjectId;
        Status = NWDAccountServiceStatus.IsActive;
        Start = NWDTimestamp.ToTimestampUnix(sStart);
        End = NWDTimestamp.ToTimestampUnix(sEnd);
        EnvironmentKind = sEnvironmentKind;
        Account = sAccount;
        Service = sService;
        Message = sMessage;
        MessageStyle = sMessageStyle;
    }

    public NWDAccountService(long sProjectId, NWDEnvironmentKind sEnvironmentKind, long sAccount, long sService, LocalDateTime sStart, LocalDateTime sEnd, String sMessage) {
        this(sProjectId, sEnvironmentKind, sAccount, sService, sStart, sEnd, sMessage, NWDBootstrapKindOfStyle.Primary);

    }


    public NWDAccountService(long sProjectId, NWDEnvironmentKind sEnvironmentKind, long sAccount, long sService, int sStart, int sEnd, String sMessage, NWDBootstrapKindOfStyle sMessageStyle) {
        projectId = sProjectId;
        Status = NWDAccountServiceStatus.IsActive;
        Start = sStart;
        End = sEnd;
        EnvironmentKind = sEnvironmentKind;
        Account = sAccount;
        Service = sService;
        Message = sMessage;
        MessageStyle = sMessageStyle;
    }

    public NWDAccountService(long sProjectId, NWDEnvironmentKind sEnvironmentKind, long sAccount, long sService, int sStart, int sEnd, String sMessage) {
        this(sProjectId, sEnvironmentKind, sAccount, sService, sStart, sEnd, sMessage, NWDBootstrapKindOfStyle.Primary);
    }

    @Override
    public boolean equals(Object obj) {
        return Reference == ((NWDAccountService) obj).Reference;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(Reference);

    }

}