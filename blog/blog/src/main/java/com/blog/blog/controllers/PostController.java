package com.blog.blog.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.blog.blog.dtos.Post.CreatePostDto;
import com.blog.blog.dtos.Post.UpdatePostDto;
import com.blog.blog.dtos.Post.UpdatedPostDto;
import com.blog.blog.entities.Post;
import com.blog.blog.services.PostService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public Post findById(@PathVariable Long id) {
        return postService.findById(id);
    }

    @GetMapping
    public ResponseEntity<Page<Post>> findAll(@RequestParam Optional<String> title,
            @PageableDefault(size = 1, page = 0) Pageable pageable) {
        return ResponseEntity.ok(postService.findAll(title, pageable));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Post> create(@Valid @RequestBody CreatePostDto requestData, UriComponentsBuilder uriBuilder) {
        Post post = new Post(requestData);

        Post createdPost = postService.create(post);

        var uri = uriBuilder.path("/posts/{id}").buildAndExpand(createdPost).toUri();

        return ResponseEntity.created(uri).body(createdPost);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<UpdatedPostDto> update(@RequestBody @Valid UpdatePostDto requestData) {
        Post post = postService.update(requestData);

        return ResponseEntity.ok(new UpdatedPostDto(post));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id) {
        postService.delete(id);

        return ResponseEntity.ok("Apagado!");
    }
}
