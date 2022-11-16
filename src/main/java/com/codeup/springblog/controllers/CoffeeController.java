package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Coffee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/coffee")
public class CoffeeController {

    @GetMapping
    public String coffee(){
        return "coffee";
    }

    @GetMapping("/{roast}")
    public String roast(@PathVariable String roast, Model model){
        Coffee selection = new Coffee();
        selection.setRoast(roast);
        selection.setOrigin("Ethiopia");
        model.addAttribute("roast",roast);
        return "coffee";
    }

    @PostMapping
    public String signup(@RequestParam(name = "email") String email, Model model){
        model.addAttribute("email",email);
        return "coffee";
    }
}
