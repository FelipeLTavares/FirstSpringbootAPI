package com.blog.blog.dtos.Post;

import com.blog.blog.entities.Post;

public record UpdatedPostDto(Long id, String title, String body, Integer userId) {
    public UpdatedPostDto (Post post) {
        this(post.getId(), post.getTitle(), post.getBody(), post.getUserId());
    }
}
