package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String viewPost(@PathVariable String id){
        return "view post at id " + id;
    }

    @GetMapping("/posts")
    @ResponseBody
    public String post(){
        return "post index page";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String postForm(){
        return "view the form for creating a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost(){
        return "create a new post";
    }
}
