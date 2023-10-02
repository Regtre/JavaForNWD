package fr.nwwdjavaspringboot.model.NWD;

import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.NWDEnvironmentKind;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.facade.INWDProjectInformation;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.facade.INWDProjectKey;

import java.math.BigInteger;

public class NWDProjectInformation implements INWDProjectInformation, INWDProjectKey {
    @Override
    public String GetProjectInformationInstanceName() {
        return null;
    }

    @Override
    public BigInteger GetProjectId() {
        return new BigInteger("1587286271");
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
        return "VRXBNXXK-ICYGYAAP-XNLWZSBJ-SQRGMTZE-TBVRWBRK-AJZITZYY-MUXCSDRX-WNPYYIBC-XBLWZIYM-ATAWYAVP";
    }

}
