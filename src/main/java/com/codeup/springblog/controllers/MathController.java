package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @GetMapping("/add/{num0}/and/{num1}")
    @ResponseBody
    public int add(@PathVariable int num0, @PathVariable int num1){
        return num0 + num1;
    }

    @GetMapping("/subtract/{num0}/from/{num1}")
    @ResponseBody
    public int subtract(@PathVariable int num0, @PathVariable int num1){
        return num0 - num1;
    }

    @GetMapping("/multiply/{num0}/and/{num1}")
    @ResponseBody
    public int multiply(@PathVariable int num0, @PathVariable int num1){
        return num0 * num1;
    }

    @GetMapping("/divide/{num0}/by/{num1}")
    @ResponseBody
    public int divide(@PathVariable int num0, @PathVariable int num1){
        return num0 / num1;
    }
}
