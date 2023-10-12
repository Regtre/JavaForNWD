package fr.nwwdjavaspringboot.controller;

import fr.nwwdjavaspringboot.model.Contact;
import fr.nwwdjavaspringboot.model.NWD.NWDBusiness.exchanges.request.NWDRequestPlayerToken;
import fr.nwwdjavaspringboot.service.ContactService;
import fr.nwwdjavaspringboot.util.ArgumentNullException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

@Controller
public class MyAccountController {

    private ContactService contactService;

    @Autowired
    public MyAccountController(ContactService cs){
        contactService = cs ;
    }

    @Autowired
    public void setContactService(ContactService cs){
        contactService = cs;
    }

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
    public String showContacts(Model model, HttpServletRequest request) {
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
        return showContacts(model, request);
    }

    @RequestMapping(value = "/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    private String deleteContact(@PathVariable("id") BigInteger contactReference, Model model, HttpServletRequest request) throws ArgumentNullException, UnsupportedEncodingException {
        contactService.remove(contactReference,
                (NWDRequestPlayerToken) request.getSession().getAttribute("playerToken"));
        return showContacts(model, request);
    }

    @PostMapping(value = "/update/{id}")
    private String updateContact(@PathVariable("id") BigInteger contactReference,
                                 @ModelAttribute Contact contact, Model model, HttpServletRequest request) throws ArgumentNullException, UnsupportedEncodingException {
        contact.reference = contactReference;
        contactService.update(contact,
                (NWDRequestPlayerToken) request.getSession().getAttribute("playerToken"));
        return showContacts(model, request);
    }

    @GetMapping(value = "/edit/{id}")
    private String updateContact(@PathVariable("id") String idRef, Model model, HttpServletRequest request) throws ArgumentNullException, UnsupportedEncodingException {

        BigInteger contactReference = new BigInteger(idRef);
        Contact contactFind = contactService.find(contactReference);
        if (contactFind == null)
            return showContacts(model, request);

        model.addAttribute("contact", contactFind);
        return "contact/edit";
    }


}
