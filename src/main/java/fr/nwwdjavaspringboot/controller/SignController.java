package fr.nwwdjavaspringboot.controller;

import fr.nwwdjavaspringboot.model.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignController {

//    @Autowired
//    ContactRepository contactRepository;


    @GetMapping("/")
    public String getIndex(){
        return "index";
    }
    @GetMapping("/sign")
    public String greetingForm(Model model) {
        model.addAttribute("account", new Account());
        return "sign/index";
    }

    @PostMapping("/sign")
    public String greetingSubmit(@ModelAttribute Account account, Model model) {
        model.addAttribute("account", account);
        return "sign/result";
    }


}
