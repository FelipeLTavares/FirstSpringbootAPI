package com.blog.blog.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.blog.blog.dtos.Post.CreatePostDto;
import com.blog.blog.entities.Post;
import com.blog.blog.services.PostService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/post")
@Validated
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> findAll() {
        List<Post> allPosts = postService.findAll();

        return ResponseEntity.ok(allPosts);
    }

    @PostMapping
    public ResponseEntity<Post> create(@Valid @RequestBody CreatePostDto requestData) {
        Post post = new Post(requestData);

        Post createdPost = postService.create(post);

        return ResponseEntity.ok(createdPost);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        postService.delete(id);

        return ResponseEntity.ok("Apagado!");
    }
}
