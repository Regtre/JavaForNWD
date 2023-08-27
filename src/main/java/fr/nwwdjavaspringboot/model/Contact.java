package fr.nwwdjavaspringboot.model;

import fr.nwwdjavaspringboot.model.NWD.NWDPlayerData;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public class Contact extends NWDPlayerData {

    public String name;
    public String firstName;
    public String enterprise;
    public String number;
    public long id;

    public Contact(String name, String firstName){
        this.name = name;
        this.firstName = firstName;
    }

    public Contact(){
        id = new Random().nextLong();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
