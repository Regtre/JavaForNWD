package fr.nwwdjavaspringboot.model.NWD;


import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.NWDProjectInformation;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.NWDRuntime;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.NWDUpPayload;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.account.NWDAccountSign;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.exchange.NWDExchangeDevice;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.exchange.NWDExchangeOrigin;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.exchange.NWDExchangeRuntimeKind;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.exchange.NWDUpPayloadAccountSignIn;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.request.NWDRequestPlayerToken;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.request.NWDRequestRuntime;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.request.NWDUpPayloadDataSyncByIncrement;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.facade.INWDProjectKey;
import fr.nwwdjavaspringboot.util.AccountUtil;
import fr.nwwdjavaspringboot.util.ArgumentNullException;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

@Component
public class RuntimeCreatorForNWD {

    private NWDRuntime nwdRuntime;

    private final INWDProjectKey projectKey = new NWDProjectInformation();
    private final NWDRequestPlayerToken playerToken = new NWDRequestPlayerToken(new NWDProjectInformation());
    private final NWDExchangeOrigin exchangeOrigin = NWDExchangeOrigin.Web;
    private final NWDExchangeDevice exchangeDevice = NWDExchangeDevice.Web;
    private final NWDAccountSign accountMail = NWDAccountSign.CreateEmailPassword(AccountUtil.ACCOUNT_MAIL, AccountUtil.ACCOUNT_MDP, playerToken.getProjectId());
    private final NWDAccountSign account = NWDAccountSign.CreateLoginPassword(AccountUtil.ACCOUNT_LOGIN, AccountUtil.ACCOUNT_MDP, playerToken.getProjectId());

    private final NWDUpPayload upPayload = new NWDUpPayloadAccountSignIn(account);

    public RuntimeCreatorForNWD() throws ArgumentNullException, UnsupportedEncodingException {
    }

    public String getApiUrl() {
        return "http://localhost:2050/NWDRuntime";
    }

    public NWDRequestRuntime signUpRequest() {
        return NWDRequestRuntime.CreateRequestSignUp(projectKey, playerToken,
                account, exchangeOrigin, exchangeDevice);
    }

    public NWDRequestRuntime signInRequest() {
        return NWDRequestRuntime.CreateRequestSignIn(projectKey, playerToken,
                account, exchangeOrigin, exchangeDevice);
    }

    private NWDRequestRuntime createRequest(String token, NWDExchangeRuntimeKind nwdExchangeRuntimeKind) {
        playerToken.setToken(token);
        playerToken.setExchangeOrigin(exchangeOrigin);
        return new NWDRequestRuntime(projectKey, playerToken, nwdExchangeRuntimeKind,
                upPayload, exchangeOrigin, exchangeDevice);
    }

    public NWDRequestRuntime syncDataRequest(NWDRequestPlayerToken pToken, NWDUpPayloadDataSyncByIncrement data) {
        return NWDRequestRuntime.CreateRequestSyncDataByIncrement(projectKey, pToken, data, exchangeOrigin, exchangeDevice);
    }

    public NWDRequestRuntime getAllPlayerDataRequest(NWDRequestPlayerToken pToken) {
        return NWDRequestRuntime.CreateGetAllPlayerData(projectKey, pToken, exchangeOrigin, exchangeDevice);
    }
}
