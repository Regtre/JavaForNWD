package fr.nwwdjavaspringboot.model.NWDBusiness;

public interface INWDProjectInformation {

    public String GetProjectInformationInstanceName();
    public long GetProjectId();
    public NWDEnvironmentKind GetProjectEnvironment();
}
