package com.blog.blog.dtos.Post;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreatePostDto(@NotBlank String title, @NotBlank String body, @NotNull String userId) {
}
