package com.blog.blog.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.blog.blog.dtos.Post.CreatePostDto;
import com.blog.blog.dtos.Post.UpdatePostDto;
import com.blog.blog.dtos.Post.UpdatedPostDto;
import com.blog.blog.entities.Post;
import com.blog.blog.services.PostService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/posts")
@Validated
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("/{id}")
    public Optional<Post> findById(@PathVariable Long id) {
        return postService.findById(id);
    }

    @GetMapping
    public List<Post> findAll(@RequestParam Optional<String> title) {
        return postService.findAll(title);
    }

    @PostMapping
    public ResponseEntity<Post> create(@Valid @RequestBody CreatePostDto requestData) {
        Post post = new Post(requestData);

        Post createdPost = postService.create(post);

        return ResponseEntity.ok(createdPost);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<UpdatedPostDto> update(@RequestBody @Valid UpdatePostDto requestData) {
        Post post = postService.update(requestData);

        return ResponseEntity.ok(new UpdatedPostDto(post));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        postService.delete(id);

        return ResponseEntity.ok("Apagado!");
    }
}
