package fr.nwwdjavaspringboot.model.NWD.NWDBusiness.facade;

import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.NWDEnvironmentKind;

import java.math.BigInteger;

public interface INWDProjectInformation {

    public String GetProjectInformationInstanceName();
    public BigInteger GetProjectId();
    public NWDEnvironmentKind GetProjectEnvironment();
}
