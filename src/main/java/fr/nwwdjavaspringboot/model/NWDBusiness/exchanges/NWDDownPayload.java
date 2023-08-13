package fr.nwwdjavaspringboot.model.NWDBusiness.exchanges;

import fr.nwwdjavaspringboot.model.NWDBusiness.NWDAccountService;

import java.util.List;

public class NWDDownPayload {

    private List<NWDAccountService> AccountServiceList;

    public List<NWDAccountService> getAccountServiceList() {
        return AccountServiceList;
    }

    public void setAccountServiceList(List<NWDAccountService> accountServiceList) {
        AccountServiceList = accountServiceList;
    }
}
