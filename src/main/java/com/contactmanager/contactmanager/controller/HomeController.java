package com.contactmanager.contactmanager.controller;


import com.contactmanager.contactmanager.entities.User;
import com.contactmanager.contactmanager.message.message;
import com.contactmanager.contactmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping("/")// to open home page
    public String home(Model model)
    {
        model.addAttribute("title","HOME PAGE");
        return "home";
    }

    @RequestMapping("/login")// to open login page
    public String login(Model model)
    {
        model.addAttribute("title","LOGIN PAGE");
        return "login";
    }

    @RequestMapping("/signup")// to open signup page
    public String signup(Model model)
    {
        model.addAttribute("title","SIGNUP PAGE");
        model.addAttribute("user",new User());
        return "signup";
    }

    @RequestMapping("/about")// to open about page
    public String about(Model model)
    {
        model.addAttribute("title","ABOUT PAGE");
        return "about";
    }

    @PostMapping("/do_register")// post request to store user data in database by redirecting it to do-register link
    public String register(@ModelAttribute("user") @Valid User user, BindingResult result1, Model model, HttpSession session)
    {
        try {
            if(result1.hasErrors()){
                System.out.println("ERROE"+result1.toString());
                model.addAttribute("user",user);// to blank the fields
                return "signup";
            }
                    user.setRole("ROLE_USER");
                    user.setEnabled(true);
                    user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
                    System.out.println("USER"+user.toString());
                    this.userRepository.save(user);
                    model.addAttribute("user", new User());
                    session.setAttribute("message",new message("Registered Successfully","alert-succes"));
                    return "signup";
        }
        catch (Exception e)
        {
            e.printStackTrace();
            model.addAttribute("user",user);
            session.setAttribute("message",new message("Something went wrong","alert-danger"));
            return "signup";
        }


    }


}
