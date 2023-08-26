package fr.nwwdjavaspringboot.model.NWDBusiness;

import fr.nwwdjavaspringboot.model.NWDBusiness.facade.INWDProjectInformation;
import fr.nwwdjavaspringboot.model.NWDBusiness.facade.INWDProjectKey;

import java.math.BigInteger;

public class NWDProjectInformation implements INWDProjectInformation, INWDProjectKey {
    @Override
    public String GetProjectInformationInstanceName() {
        return null;
    }

    @Override
    public BigInteger GetProjectId() {
        return new BigInteger("1494237104");
    }

    @Override
    public NWDEnvironmentKind GetProjectEnvironment() {
        return NWDEnvironmentKind.Dev;
    }

    @Override
    public String getProjectKeyInstanceName() {
        return " ";
    }

    @Override
    public String getProjectKey(BigInteger sProjectId, NWDEnvironmentKind sEnvironmentKind) {
        return "NKGINSAO-PWOITOII-AQBJRLHJ-LEEDNLFN-JGZZAAYI-DXXICEZV-FXVTMPTJ-CFPOUXES-BISKPNYD-NUHQZTCS";
    }
}
