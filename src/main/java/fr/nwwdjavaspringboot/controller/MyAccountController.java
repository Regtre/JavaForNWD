package fr.nwwdjavaspringboot.controller;

import fr.nwwdjavaspringboot.model.Contact;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.request.NWDRequestPlayerToken;
import fr.nwwdjavaspringboot.model.SessionPlayerToken;
import fr.nwwdjavaspringboot.service.ContactService;
import fr.nwwdjavaspringboot.util.ArgumentNullException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

@SessionScope
@Controller
public class MyAccountController {

    @Autowired
    ContactService contactService;
    @Autowired
    SessionPlayerToken playerToken;

    @GetMapping("/index")
    public String index(Model model, HttpServletRequest request) {
        model.addAttribute("user", ((NWDRequestPlayerToken)
                request.getSession().getAttribute("playerToken")).getPlayerReference());
        return "contact/myAccount";
    }

    @GetMapping("/simulatedUser")
    public String simulatedUser(Model model, HttpServletRequest request) throws ArgumentNullException, UnsupportedEncodingException {
        request.getSession().setAttribute("playerToken", contactService.simulatedUser());
        return index(model, request);
    }

    @GetMapping("/all")
    public String showUserList(Model model, HttpServletRequest request) {
        model.addAttribute("contacts", contactService.findAll(
                (NWDRequestPlayerToken) request.getSession().getAttribute("playerToken")));
        return "contact/contactList";
    }

    @GetMapping("/contact")
    public String greetingForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact/contact";
    }

    @PostMapping("/contact")
    public String createContact(@ModelAttribute Contact contact, Model model, HttpServletRequest request) {
        model.addAttribute("contact", contact);
        contactService.create(contact,
                (NWDRequestPlayerToken) request.getSession().getAttribute("playerToken"));
        return showUserList(model, request);
    }

    //    @DeleteMapping("/delete/{id}")
    @RequestMapping(value = "/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    private String deleteContact(@PathVariable("id") BigInteger contactReference, Model model, HttpServletRequest request) throws ArgumentNullException, UnsupportedEncodingException {
        new ContactService().remove(contactReference,
                (NWDRequestPlayerToken) request.getSession().getAttribute("playerToken"));
        return showUserList(model, request);
    }

    @PostMapping(value = "/update/{id}")
    private String updateContact(@PathVariable("id") BigInteger contactReference,
                                 @ModelAttribute Contact contact, Model model, HttpServletRequest request) throws ArgumentNullException, UnsupportedEncodingException {
        contact.reference = contactReference;
        new ContactService().update(contact,
                (NWDRequestPlayerToken) request.getSession().getAttribute("playerToken"));
        return showUserList(model, request);
    }

    @GetMapping(value = "/edit/{id}")
    private String updateContact(@PathVariable("id") BigInteger contactReference, Model model, HttpServletRequest request) throws ArgumentNullException, UnsupportedEncodingException {

        model.addAttribute("contact", new ContactService().find(contactReference));
        return "contact/edit";
    }


}
