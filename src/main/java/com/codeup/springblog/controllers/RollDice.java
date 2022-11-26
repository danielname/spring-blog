package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Coffee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/roll-dice")
public class RollDice {

    @GetMapping
    public String rollDice(){
        return "roll-dice";
    }

    @GetMapping("/{number}")
    public String roast(@PathVariable byte number, Model model){
        model.addAttribute("num",number);
        model.addAttribute("random", (int) Math.ceil(Math.random()*6));
        return "roll-dice";
    }

}
