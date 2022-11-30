package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import com.codeup.springblog.service.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posts")
public class PostController {
    private final PostRepository postDao;
    private final UserRepository userDao;
    private final EmailService emailService;

    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
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
//        Post post = postDao.findById(id);
        model.addAttribute("post",postDao.findById(id));
        model.addAttribute("user",userDao.findById(1L));
        return "posts/show";
    }

//    @GetMapping("/show")
//    public String postOne(){
//        return "posts/show";
//    }

    @GetMapping("/create")
    public String postForm(Model model){
        model.addAttribute("post", new Post());
        return "/posts/create";
    }

    @PostMapping("/create")
    public String submitPost(@ModelAttribute Post post){
        postDao.save(post);
        emailService.prepareAndSend(post,"","");
        return "redirect:index";
    }

    @GetMapping("/{id}/edit")
    public String editForm(Model model, @PathVariable long id){
        model.addAttribute("post", postDao.findById(id));
        //might want to store the db call in a variable if there is more than one call.
        return "/posts/edit";
    }

    @PostMapping("/{id}/edit")
    public String submitEdit(@ModelAttribute Post post){
        postDao.save(post);
        return "redirect:index";
    }
}
