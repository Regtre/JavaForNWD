package fr.nwwdjavaspringboot.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {

    public String name = "LeKing";
    public String mail = "r.poissonnier@gmail.com";
    public String password = "REMY_le_KING";

    public Account(){}
}
