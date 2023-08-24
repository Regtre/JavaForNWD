package fr.nwwdjavaspringboot.controller;

import fr.nwwdjavaspringboot.model.NWDBusiness.exchanges.NWDPlayerDataStorage;
import fr.nwwdjavaspringboot.repository.PlayerDataRepository;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@Configuration
@EnableAutoConfiguration
@RequestMapping("playerData")
public class PlayerDataController {

/*
    private final PlayerDataRepository repository;

    PlayerDataController(PlayerDataRepository repository) {
        this.repository = repository;
    }
*/

    @GetMapping("/")
    public String page(Model model){
        model.addAttribute("attr","attr");
        return "data-player";
    }

/*    @GetMapping("/players")
    List<NWDPlayerDataStorage> all() {
        return repository.findAll();
    }*/
}
