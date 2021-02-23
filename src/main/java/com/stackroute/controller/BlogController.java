package com.stackroute.controller;


import com.stackroute.domain.Blog;
import com.stackroute.service.BlogService;
import com.stackroute.service.BlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* Add annotation to declare this class as REST Controller */
@RestController
@RequestMapping("/api/v1/")
public class BlogController {

    /* Provide implementation code for these methods */
    @Autowired
    BlogService service;

    /*This method should save blog and return savedBlog Object */
    @PostMapping("/blog")
    public ResponseEntity<Blog> saveBlog(@RequestBody Blog blog) throws Exception {
        return new ResponseEntity<Blog>(service.saveBlog(blog), HttpStatus.CREATED);
    }

    @GetMapping("/blogs")
    /*This method should fetch all blogs and return the list of all blogs */
    public ResponseEntity<List> getAllBlogs() throws Exception {
        return new ResponseEntity<List>(service.getAllBlogs(), HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    /*This method should fetch the blog taking its id and return the respective blog */
    public ResponseEntity<Blog> getBlogById(@PathVariable int id) throws Exception {
        return new ResponseEntity<>(service.getBlogById(id), HttpStatus.FOUND);
    }

    @DeleteMapping("/blog/{id}")
    /*This method should delete the blog taking its id and return the deleted blog */
    public ResponseEntity<Blog> getBlogAfterDeleting(@PathVariable int id) throws Exception {
        return new ResponseEntity<>(service.deleteBlog(id), HttpStatus.OK);
    }

    @PutMapping("/blog")
    /*This method should update blog and return the updatedBlog */
    public ResponseEntity<?> updateBlog(@RequestBody Blog blog) throws Exception {
        return new ResponseEntity<>(service.updateBlog(blog), HttpStatus.OK);
    }

//    @ExceptionHandler(value = Exception.class)
//    public ResponseEntity<String> handle(){
//        return new ResponseEntity<String>("message", HttpStatus.OK);
//    }
}