package com.stackroute.service;

import com.stackroute.domain.Blog;

import java.util.List;

public interface BlogService {
    /**
     * AbstractMethod to save a blog
     */
    Blog saveBlog(Blog blog) throws Exception;

    /**
     * AbstractMethod to get all blogs
     */
    List<Blog> getAllBlogs() throws Exception;

    /**
     * AbstractMethod to get blog by id
     */
    Blog getBlogById(int id) throws Exception;

    /**
     * AbstractMethod to delete blog by id
     */
    Blog deleteBlog(int id) throws Exception;

    /**
     * AbstractMethod to update a blog
     */
    Blog updateBlog(Blog blog) throws Exception;
}
