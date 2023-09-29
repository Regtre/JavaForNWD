package fr.nwwdjavaspringboot.controller;

import fr.nwwdjavaspringboot.model.Contact;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.request.NWDRequestPlayerToken;
import fr.nwwdjavaspringboot.model.NWD.RuntimeCreatorForNWD;
import fr.nwwdjavaspringboot.model.SessionPlayerToken;
import fr.nwwdjavaspringboot.repository.ContactRepository;
import fr.nwwdjavaspringboot.repository.RequestSenderForNWD;
import fr.nwwdjavaspringboot.util.ArgumentNullException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.annotation.SessionScope;

import java.io.UnsupportedEncodingException;

@SessionScope
@Controller
public class ContactController {

    @Autowired
    ContactRepository contactRepository;
    @Autowired
    SessionPlayerToken playerToken;

    @GetMapping("/index")
    public String index(Model model, HttpServletRequest request) {
        model.addAttribute("user",((NWDRequestPlayerToken)
                request.getSession().getAttribute("playerToken")).getPlayerReference());
        return "contact/myAccount";
    }

    @GetMapping("/simulatedUser")
    public String simulatedUser(Model model, HttpServletRequest request) throws ArgumentNullException, UnsupportedEncodingException {
        request.getSession().setAttribute("playerToken",contactRepository.simuletUser());
        return index(model, request);
    }

    @GetMapping("/all")
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
    public String greetingSubmit(@ModelAttribute Contact contact, Model model, HttpServletRequest request) {
        model.addAttribute("contact", contact);
        contactRepository.create(contact,
                (NWDRequestPlayerToken) request.getSession().getAttribute("playerToken"));
        return "contact/result";
    }



}
