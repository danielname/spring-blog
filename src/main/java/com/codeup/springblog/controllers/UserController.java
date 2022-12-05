package com.codeup.springblog.controllers;

import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private final PostRepository postDao;
    private final UserRepository userDao;
    private final PasswordEncoder passwordEncoder;

    public UserController(PostRepository postDao, UserRepository userDao, PasswordEncoder passwordEncoder) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        model.addAttribute("user", new User());
        return "/authentication/registration";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.save(user);
        return "redirect:/posts/create";
    }

    @GetMapping("/posts/profile_list")
    public String allPosts(Model model) {
        model.addAttribute("allUsers", userDao.findAll());
        return "posts/profile_list";
    }
}
