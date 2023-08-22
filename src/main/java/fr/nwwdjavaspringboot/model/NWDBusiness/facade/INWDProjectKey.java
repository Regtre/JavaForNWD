package fr.nwwdjavaspringboot.model.NWDBusiness.facade;

import fr.nwwdjavaspringboot.model.NWDBusiness.NWDEnvironmentKind;

public interface INWDProjectKey {
    public String getProjectKeyInstanceName();
    public String getProjectKey(long sProjectId, NWDEnvironmentKind sEnvironmentKind);
}