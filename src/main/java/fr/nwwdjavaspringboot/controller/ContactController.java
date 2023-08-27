package fr.nwwdjavaspringboot.controller;

import fr.nwwdjavaspringboot.model.Contact;
import fr.nwwdjavaspringboot.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactController {

    @Autowired
    ContactRepository contactRepository;

    @GetMapping("/index")
    public String showUserList(Model model) {
        model.addAttribute("contacts", contactRepository.findAll());
        return "contact/index";
    }
    @GetMapping("/contact")
    public String greetingForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact/contact";
    }

    @PostMapping("/contact")
    public String greetingSubmit(@ModelAttribute Contact contact, Model model) {
        model.addAttribute("contact", contact);
        contactRepository.create(contact);
        return "contact/result";
    }

}
