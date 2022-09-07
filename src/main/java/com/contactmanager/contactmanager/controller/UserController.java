package com.contactmanager.contactmanager.controller;

import com.contactmanager.contactmanager.entities.Contact;
import com.contactmanager.contactmanager.entities.User;
import com.contactmanager.contactmanager.message.message;
import com.contactmanager.contactmanager.repository.ContactRepository;
import com.contactmanager.contactmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ContactRepository contactRepository;


    // This method run for every method index, add_contact or etc.
    // Method for adding common data for response.
    @ModelAttribute
    public void addCommonData(Model model, Principal principal) {
        String userName = principal.getName();// give us users unique identification in my case give us email id
        User user = userRepository.getUserByUserName(userName);
        model.addAttribute("user", user);
    }

    @RequestMapping("/index")
    public String dashboard(Model model){
        model.addAttribute("title","Dashboard");
        return "users/dashboard";
    }

    @RequestMapping("/person")
    public String profile(Model model){
        model.addAttribute("title","Profile");
        return "users/profile";
    }


    @RequestMapping("/updateuser")//TO show user details in update page
    public String showUpdateForm( Model model,Principal principal) {
        String username=principal.getName();
        User user = userRepository.getUserByUserName(username);
        model.addAttribute("user", user);
        model.addAttribute("title","Update User");
        return "users/userupdate";
    }

    @PostMapping("/updateduser") //TO save updated user details
    public String updateuser(Model model, @Valid User user){
        userRepository.save(user);
        model.addAttribute("title","User Updated");
        return "users/profile";
    }


    @RequestMapping("/addcontact")
    public String addcontact(Model model){
        model.addAttribute("contact",new Contact());
        model.addAttribute("title","ADD CONTACT");
        return "users/addContact";
    }

    @PostMapping("/do_save")// post method to save contact
    public String addContact(@ModelAttribute("contact")@Valid Contact contact, BindingResult result2, Model model, Principal principal, HttpSession session){

        try {
            if(result2.hasErrors()){
                System.out.println("ERROE"+result2.toString());
                model.addAttribute("contact",contact);// to blank the fields
                return "users/addContact";
            }
            String username=principal.getName();
            User user = userRepository.getUserByUserName(username);
            contact.setUser(user);
            user.getContacts().add(contact);
            this.userRepository.save(user);
            session.setAttribute("message",new message("SAVED Successfully","alert-succes"));
            model.addAttribute("contact",new Contact());
            return "users/addContact";
        }
        catch (Exception e)
        {
            e.printStackTrace();
            model.addAttribute("contact",contact);
            session.setAttribute("message",new message("Something went wrong","alert-danger"));
            return "users/addContact";
        }
    }

//    per page=5[n]
//    current page=0[page]
    @RequestMapping("/viewcontact/{page}")
    public String viewcontact(@PathVariable("page") Integer page, Model model, Principal principal){
        model.addAttribute("title","View-Contacts");

        String userName=principal.getName();
        User user=this.userRepository.getUserByUserName(userName);

        Pageable pageable= PageRequest.of(page,5);

        Page<Contact> contacts=this.contactRepository.getContactsByUser(user.getId(),pageable);
        model.addAttribute("contacts",contacts);
        model.addAttribute("currentPage",page);
        model.addAttribute("totalPage",contacts.getTotalPages());
        return "users/viewContact";
    }



}
