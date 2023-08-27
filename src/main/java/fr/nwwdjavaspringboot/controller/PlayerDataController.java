package fr.nwwdjavaspringboot.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Configuration
@EnableAutoConfiguration
@RequestMapping("playerData")
public class PlayerDataController {


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
