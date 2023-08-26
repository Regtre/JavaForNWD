package fr.nwwdjavaspringboot.model.NWDBusiness;

import fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.NWDAccountServiceKind;
import lombok.Getter;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
public class NWDAccountService extends NWDAccountData implements Serializable {

    public NWDAccountServiceKind serviceKind = NWDAccountServiceKind.Original;
    public NWDEnvironmentKind environmentKind;
    public String name;
    public long service;
    public NWDReference<NWDAccount> offerByAccount = new NWDReference<NWDAccount>();
    public NWDReference<NWDAccountService> fromAccountService = new NWDReference<NWDAccountService>();

    public NWDReference<NWDAccount> toAccount = new NWDReference<NWDAccount>();
    public NWDReference<NWDAccountService> toAccountService = new NWDReference<NWDAccountService>();

    public NWDBootstrapKindOfStyle messageStyle = NWDBootstrapKindOfStyle.Primary;
    public String message = ""; // use to show special message for this services


    public NWDAccountServiceStatus status = NWDAccountServiceStatus.IsInactive;
    public int duration = 0;
    public boolean uniqueService = false;
    /// <summary>
    /// use to override service by name ... if service with service number and name already exist => override it with this information
    /// </summary>
    public boolean overrideByName = false;

    public String ip;
    public String cookie;
    public int offlineCounterDown = 0;
    public int start = 0;
    public int end = 0;

    public NWDAccountService() {
    }

    public NWDAccountService(BigInteger sProjectId, NWDEnvironmentKind sEnvironmentKind, long sAccount, long sService, LocalDateTime sStart, LocalDateTime sEnd, String sMessage, NWDBootstrapKindOfStyle sMessageStyle) {
        projectId = sProjectId;
        status = NWDAccountServiceStatus.IsActive;
        start = NWDTimestamp.ToTimestampUnix(sStart);
        end = NWDTimestamp.ToTimestampUnix(sEnd);
        environmentKind = sEnvironmentKind;
        account = sAccount;
        service = sService;
        message = sMessage;
        messageStyle = sMessageStyle;
    }

    public NWDAccountService(BigInteger sProjectId, NWDEnvironmentKind sEnvironmentKind, long sAccount, long sService, LocalDateTime sStart, LocalDateTime sEnd, String sMessage) {
        this(sProjectId, sEnvironmentKind, sAccount, sService, sStart, sEnd, sMessage, NWDBootstrapKindOfStyle.Primary);

    }


    public NWDAccountService(BigInteger sProjectId, NWDEnvironmentKind sEnvironmentKind, long sAccount, long sService, int sStart, int sEnd, String sMessage, NWDBootstrapKindOfStyle sMessageStyle) {
        projectId = sProjectId;
        status = NWDAccountServiceStatus.IsActive;
        start = sStart;
        end = sEnd;
        environmentKind = sEnvironmentKind;
        account = sAccount;
        service = sService;
        message = sMessage;
        messageStyle = sMessageStyle;
    }

    public NWDAccountService(BigInteger sProjectId, NWDEnvironmentKind sEnvironmentKind, long sAccount, long sService, int sStart, int sEnd, String sMessage) {
        this(sProjectId, sEnvironmentKind, sAccount, sService, sStart, sEnd, sMessage, NWDBootstrapKindOfStyle.Primary);
    }

    @Override
    public boolean equals(Object obj) {
        return Objects.equals(reference, ((NWDAccountService) obj).reference);
    }

    @Override
    public int hashCode() {
        return reference.hashCode();

    }

}