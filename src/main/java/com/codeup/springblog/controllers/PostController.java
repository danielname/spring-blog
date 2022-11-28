package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posts")
public class PostController {
    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }

    @GetMapping("/index")
    public String allPosts(Model model){
//        Post post1 = new Post(1, "First", "This is the first post");
//        Post post2 = new Post(2, "Second", "This is the second post");
//        List<Post> allPosts = postDao.findAll();
        model.addAttribute("allPosts",postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/show/{id}")
    public String viewPost(@PathVariable long id, Model model){
        Post post = postDao.findById(id);
        model.addAttribute("post.id",id);
        return "posts/show";
    }

    @GetMapping("/show")
    public String postOne(){
        Post post3 = new Post(3,"three","third post");
        return "posts/show";
    }

    @GetMapping("/create")
    public String postForm(Model model){
        model.addAttribute("post", new Post());
        return "/posts/create";
    }

    @PostMapping("/create")
    public String submitPost(@ModelAttribute Post post){
        postDao.save(post);
        return "redirect:index";
    }


}
