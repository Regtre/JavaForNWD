package fr.nwwdjavaspringboot.model;

public class Contact extends NWDPlayerData {

    public String name;
    public String firstName;
    public String Enterprise;
    public String number;

    public Contact(String name, String firstName){
        this.name = name;
        this.firstName = firstName;
    }
}
