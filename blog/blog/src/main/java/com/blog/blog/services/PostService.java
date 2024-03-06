package com.blog.blog.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.blog.blog.dtos.Post.UpdatePostDto;
import com.blog.blog.entities.Post;
import com.blog.blog.repositories.PostRepository;

import jakarta.validation.Valid;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }

    public Page<Post> findAll(Optional<String> title, Pageable pageable) {
        String titleToSearch = title.orElse("");

        return postRepository.findByTitleContainingIgnoreCase(titleToSearch, pageable);
    }

    public Post create(Post postData) {
        Post createdUser = postRepository.save(postData);

        return createdUser;
    }

    public Post update(@Valid UpdatePostDto updateData) {
        Post post = postRepository.getReferenceById(updateData.id());

        if (updateData.title() != null) {
            post.setTitle(updateData.title());
        }

        if (updateData.body() != null) {
            post.setBody(updateData.body());
        }

        return post;
    }

    public void delete(Long id) {
        postRepository.deleteById(id);
    }
}
