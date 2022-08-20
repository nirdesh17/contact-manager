package com.contactmanager.contactmanager.controller;

import com.contactmanager.contactmanager.entities.User;
import com.contactmanager.contactmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;


}
