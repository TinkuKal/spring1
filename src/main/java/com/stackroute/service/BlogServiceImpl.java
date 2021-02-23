package com.stackroute.service;


import com.stackroute.domain.Blog;
import com.stackroute.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/* Add annotation to declare this class as Service class.
 * Also it should implement BlogService Interface and override all the implemented methods.*/
@Service
public class BlogServiceImpl implements BlogService{

  @Autowired
  BlogRepository repository;

  @Override
  public Blog saveBlog(Blog blog) {
    repository.save(blog);
    return blog;
  }

  @Override
  public List<Blog> getAllBlogs() {
    return (List<Blog>) repository.findAll();
  }

  @Override
  public Blog getBlogById(int id) {
    Optional<Blog> blog = repository.findById(id);
    if(blog.isPresent()){
      return blog.get();
    }
    return null;
  }

  @Override
  public Blog deleteBlog(int id) {
    Optional<Blog> b = repository.findById(id);
    if(b.isPresent()){
      Optional<Blog> b1 = repository.findById(id);
      Blog blog = b.get();
      repository.deleteById(id);
      return blog;
    }
    return null;
  }

  @Override
  public Blog updateBlog(Blog blog) {
    Optional<Blog> b = repository.findById(blog.getBlogId());
    if(b.isPresent()){
      Optional<Blog> b1 = repository.findById(blog.getBlogId());
      Blog save = repository.save(blog);
      return save;
    }
    return null;
  }
}
