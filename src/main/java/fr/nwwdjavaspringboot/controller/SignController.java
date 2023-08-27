package fr.nwwdjavaspringboot.controller;

import fr.nwwdjavaspringboot.model.Account;
import fr.nwwdjavaspringboot.model.Contact;
import fr.nwwdjavaspringboot.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import java.util.Arrays;
import java.util.Properties;

@Controller
public class SignController {

//    @Autowired
//    ContactRepository contactRepository;

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
