package com.contactmanager.contactmanager.controller;


import com.contactmanager.contactmanager.entities.User;
import com.contactmanager.contactmanager.message.message;
import com.contactmanager.contactmanager.repository.UserRepository;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    public String home(Model model)
    {
        model.addAttribute("title","HOME PAGE");
        return "home";
    }

    @RequestMapping("/login")
    public String login(Model model)
    {
        model.addAttribute("title","LOGIN PAGE");
        return "login";
    }

    @RequestMapping("/signup")
    public String signup(Model model)
    {
        model.addAttribute("title","SIGNUP PAGE");
        model.addAttribute("user",new User());
        return "signup";
    }

    @RequestMapping("/about")
    public String about(Model model)
    {
        model.addAttribute("title","ABOUT PAGE");
        return "about";
    }

    @PostMapping("/do_register")
    public String register(@ModelAttribute("user") User user, Model model, HttpSession session)
    {
        try {
        user.setRole("ROLE_USER");
        user.setEnabled(true);
        System.out.println("USER"+user);
        this.userRepository.save(user);
            session.setAttribute("message",new message("Registered Successfully","alert-succes"));
            return "signup";
        }
        catch (Exception e)
        {
            e.printStackTrace();
            model.addAttribute("user",user);
            session.setAttribute("message",new message("Something went wrong"+e.getMessage(),"alert-danger"));
            return "signup";
        }

    }


}
