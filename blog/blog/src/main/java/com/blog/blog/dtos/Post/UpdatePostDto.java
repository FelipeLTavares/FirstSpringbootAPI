package com.blog.blog.dtos.Post;

import jakarta.validation.constraints.NotNull;

public record UpdatePostDto(@NotNull Long id, String title, String body) {
}
