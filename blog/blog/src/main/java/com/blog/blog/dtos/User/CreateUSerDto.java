package com.blog.blog.dtos.User;

import jakarta.validation.constraints.NotBlank;

public record CreateUSerDto(@NotBlank String name) {
}
