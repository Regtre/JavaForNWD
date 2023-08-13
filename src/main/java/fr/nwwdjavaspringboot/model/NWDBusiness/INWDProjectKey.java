package fr.nwwdjavaspringboot.model.NWDBusiness;

public interface INWDProjectKey {
    public String getProjectKeyInstanceName();
    public String getProjectKey(long sProjectId, NWDEnvironmentKind sEnvironmentKind);
}