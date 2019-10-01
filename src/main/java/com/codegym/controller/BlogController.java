package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private  BlogService blogService;

    @RequestMapping("/")
    public ModelAndView index() {
        return getAllBlog();
    }


    @RequestMapping("/list")
    public ModelAndView getAllBlog() {
        List<Blog> blogList = blogService.findAll();
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("blogs",blogList);

        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createForm(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("blogForm", new Blog());

        return modelAndView;
    }

    @PostMapping("//save-blog")
    public ModelAndView saveBlog(@ModelAttribute Blog blog) {
        blogService.save(blog);

        return getAllBlog();
    }

    @GetMapping("/read/{id}")
    public ModelAndView readContent(@PathVariable Long id) {
        Blog blog = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/read");
        modelAndView.addObject("blog",blog);

        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Blog blog = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("blog",blog);

        return modelAndView;
    }

    @PostMapping("/update-blog")
    public ModelAndView updateBlog(@ModelAttribute Blog blog) {
        blogService.save(blog);

        return getAllBlog();
    }

    @GetMapping("/remove/{id}")
    public ModelAndView showRemoveForm(@PathVariable Long id){
        Blog blog = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/remove");
        modelAndView.addObject("blog",blog);

        return modelAndView;
    }

    @PostMapping("delete-blog/{id}")
    public ModelAndView removeBlog(@PathVariable Long id) {
        blogService.remove(id);

        return getAllBlog();
    }
}
