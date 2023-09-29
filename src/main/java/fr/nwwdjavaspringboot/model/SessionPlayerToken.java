package fr.nwwdjavaspringboot.model;

import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.request.NWDRequestPlayerToken;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class SessionPlayerToken {
    public NWDRequestPlayerToken playerToken;
}
