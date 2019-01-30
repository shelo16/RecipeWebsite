package com.tornikeshelia.springboot.recipeapp.controller;

import com.tornikeshelia.springboot.recipeapp.securityModel.UserRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private JdbcUserDetailsManager jdbcUserDetailsManager;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/register")
    public String register(Model model){
        UserRegistration userRegistration = new UserRegistration();
        model.addAttribute("user", userRegistration);
        return "register-page";
    }

    @PostMapping("/register")
    public String postRegister(@ModelAttribute("user") UserRegistration userRegistrationObject){
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

        String encodedPassword = bCryptPasswordEncoder.encode(userRegistrationObject.getPassword());

        User user = new User(userRegistrationObject.getUsername(),encodedPassword,authorities);
        jdbcUserDetailsManager.createUser(user);
        return "redirect:/";


    }

}
