package fr.nwwdjavaspringboot.model.NWDBusiness.facade;

import fr.nwwdjavaspringboot.model.NWDBusiness.NWDEnvironmentKind;

public interface INWDProjectInformation {

    public String GetProjectInformationInstanceName();
    public long GetProjectId();
    public NWDEnvironmentKind GetProjectEnvironment();
}
