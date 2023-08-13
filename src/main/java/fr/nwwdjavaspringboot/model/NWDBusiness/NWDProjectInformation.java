package fr.nwwdjavaspringboot.model.NWDBusiness;

public class NWDProjectInformation implements INWDProjectInformation,INWDProjectKey {
    @Override
    public String GetProjectInformationInstanceName() {
        return null;
    }

    @Override
    public long GetProjectId() {
        return 1555938436;
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
    public String getProjectKey(long sProjectId, NWDEnvironmentKind sEnvironmentKind) {
        return"LZCUYZAX-DTNNWVQW-FPVRFWUZ-EBMJGOUG-YKBHXRGZ-BRJTAUPB-WAQKUJPT-UMYQMAUG-ELXYPSYV-JDQHNDFF";
    }
}
