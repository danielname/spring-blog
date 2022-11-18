package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posts")
public class PostController {

    @GetMapping("/show/{id}")
    @ResponseBody
    public String viewPost(@PathVariable String id, Model model){
        model.addAttribute("id",id);
        return "show";
    }

    @GetMapping("/show")
    @ResponseBody
    public String post(){
        return "show";
    }

    @GetMapping("/show/create")
    @ResponseBody
    public String postForm(){
        return "show";
    }

    @PostMapping("/create")
    @ResponseBody
    public String createPost(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body){
        Post post = new Post(title, body);
        return "index";
    }
}
