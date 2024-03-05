package com.blog.blog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.blog.entities.Post;
import com.blog.blog.repositories.PostRepository;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public List<Post> findAll() {
        List<Post> allUsers = postRepository.findAll();

        return allUsers;
    }

    public Post create(Post postData) {
        Post createdUser = postRepository.save(postData);

        return createdUser;
    }

    public void delete(Long id) {
        postRepository.deleteById(id);
    }
}
