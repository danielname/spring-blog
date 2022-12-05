package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import com.codeup.springblog.service.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
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
        model.addAttribute("allPosts",postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/show/{id}")
    public String viewPost(@PathVariable long id, Model model){
        model.addAttribute("post",postDao.findById(id));
        model.addAttribute("user",userDao.findById(1L)); //kjfhpadshgiprasgpoirasfgipufasopgfsapiodgiop
        return "posts/show";
    }


    @GetMapping("/create")
    public String postForm(Model model){
        long currentUserId = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()
        ).getId();
        if (currentUserId == 0) {
            return "redirect:/login";
        }
        model.addAttribute("post", new Post());
        return "/posts/create";
    }

    @PostMapping("/create")
    public String submitPost(@ModelAttribute Post post){
        long activeUserId = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        post.setUser(userDao.findById(activeUserId));
        postDao.save(post);
        emailService.prepareAndSend(post,post.getTitle(),post.getBody());
        return "redirect:index";
    }

    @GetMapping("/{id}/edit")
    public String editForm(Model model, @PathVariable long id){
        long currentUserId = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()
        ).getId();
        if (currentUserId == 0) {
            return "redirect:/login";
        }
        Post post = postDao.findById(id);
        if (post.getUser().getId() != currentUserId){;
            return "redirect:/posts";
        }
        model.addAttribute("post", postDao.findById(id));
        //might want to store the db call in a variable if there is more than one call.
        return "/posts/edit";
    }

    @PostMapping("/{id}/edit")
    public String submitEdit(@ModelAttribute Post post){
        postDao.save(post);
        return "redirect:index";
    }

    @GetMapping("/test")
    public String showTest(){
        return "/posts/test";
    }

    @PostMapping("/test")
    public String receiveTest(){
        System.out.println("Hello");
        return "redirect:/posts/test";
    }
}
