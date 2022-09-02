package com.contactmanager.contactmanager.controller;

import com.contactmanager.contactmanager.entities.User;
import com.contactmanager.contactmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import java.security.Principal;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


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
    @RequestMapping("/addcontact")
    public String addcontact(Model model){
        model.addAttribute("title","Profile");
        return "users/addContact";
    }
    @RequestMapping("/viewcontact")
    public String viewcontact(Model model){
        model.addAttribute("title","Profile");
        return "users/viewContact";
    }
}
