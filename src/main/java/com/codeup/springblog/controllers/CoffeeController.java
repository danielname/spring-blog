package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Coffee;
import com.codeup.springblog.repositories.CoffeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/coffee")
public class CoffeeController {

    private final CoffeeRepository coffeeDao;

    public CoffeeController(CoffeeRepository coffeeDao){
        this.coffeeDao = coffeeDao;
    }

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

    @GetMapping("/new")
    public String addCoffeeForm(){
        return "create-coffee";
    }
    @PostMapping("/new")
    public String addCoffee(@RequestParam(name = "roast") String roast, @RequestParam(name = "origin") String origin, @RequestParam(name = "brand") String brand){
        Coffee coffee = new Coffee(roast,origin,brand);
        coffeeDao.save(coffee);
        return "create-coffee";
    }
}
