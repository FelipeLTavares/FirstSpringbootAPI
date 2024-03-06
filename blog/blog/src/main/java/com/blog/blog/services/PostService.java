package com.blog.blog.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.blog.entities.Post;
import com.blog.blog.repositories.PostRepository;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }

    public List<Post> findAll(Optional<String> title) {
        String titleToSearch = title.orElse("");

        return postRepository.findByTitleContainingIgnoreCase(titleToSearch);
    }

    public Post create(Post postData) {
        Post createdUser = postRepository.save(postData);

        return createdUser;
    }

    public void delete(Long id) {
        postRepository.deleteById(id);
    }
}
