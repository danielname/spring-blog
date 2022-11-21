package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.repositories.PostRepository;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {
    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/index")
    public String allPosts(Model model){
//        Post post1 = new Post(1, "First", "This is the first post");
//        Post post2 = new Post(2, "Second", "This is the second post");
//        List<Post> allPosts = new ArrayList<>(List.of(post1, post2));
        model.addAttribute("allPosts",postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/show/{id}")
    public String viewPost(@PathVariable String id, Model model){
        model.addAttribute("post.id",id);
        return "posts/show";
    }

    @GetMapping("/show")
    public String postOne(){
        Post post3 = new Post(3,"three","third post");
        return "posts/show";
    }

    @GetMapping("/create")
    public String postForm(){
        return "/posts/create";
    }

    @PostMapping("/create")
    public String createPost(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body){
        Post post = new Post(title, body);
//            postDao.save(coffee);
            return "/index";
    }
}
