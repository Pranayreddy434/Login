package com.pranay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.pranay.service.LoginService;
import com.pranay.model.Login;

@Controller
public class LoginController {
    @Autowired
    private LoginService ser;

    @GetMapping("/")
    public String homepage() {
        return "index"; 
    }

    @GetMapping("/signup")
    public String signup() {
        return "Signup"; 
    }

    @PostMapping("/signup")
    public String signUpUser(@ModelAttribute Login login) {
        ser.registerUser(login); 
        return "redirect:/signin"; 
    }

    @GetMapping("/signin")
    public String signin() {
        return "Signin";
    }

    @PostMapping("/signin")
    public String signInUser(@RequestParam String name, @RequestParam String password, Model model) {
        Login user = ser.validateUser(name, password);
        if (user != null) {
            model.addAttribute("username", user.getName());
            return "home";
        }
        model.addAttribute("error", "Invalid credentials. Please try again.");
        return "Signin";
    }
}
