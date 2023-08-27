package fr.nwwdjavaspringboot.model.NWD.NWDBusiness.facade;

import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.NWDEnvironmentKind;

import java.math.BigInteger;

public interface INWDProjectKey {
    public String getProjectKeyInstanceName();
    public String getProjectKey(BigInteger sProjectId, NWDEnvironmentKind sEnvironmentKind);
}