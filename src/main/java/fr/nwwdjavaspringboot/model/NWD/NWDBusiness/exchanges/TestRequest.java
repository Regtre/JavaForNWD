package fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges;

public class TestRequest {

    private String Name ;

    public TestRequest(String sName){
        Name = sName;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
