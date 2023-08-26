package fr.nwwdjavaspringboot.model.NWDBusiness.facade;

import fr.nwwdjavaspringboot.model.NWDBusiness.NWDEnvironmentKind;

import java.math.BigInteger;

public interface INWDProjectInformation {

    public String GetProjectInformationInstanceName();
    public BigInteger GetProjectId();
    public NWDEnvironmentKind GetProjectEnvironment();
}
