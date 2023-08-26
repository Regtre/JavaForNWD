package fr.nwwdjavaspringboot.model.NWDBusiness.facade;

import fr.nwwdjavaspringboot.model.NWDBusiness.NWDEnvironmentKind;

import java.math.BigInteger;

public interface INWDProjectKey {
    public String getProjectKeyInstanceName();
    public String getProjectKey(BigInteger sProjectId, NWDEnvironmentKind sEnvironmentKind);
}