package com.blog.blog.dtos.User;

import jakarta.validation.constraints.NotNull;

public record UpdateUserDto(@NotNull Long id, String name) {
}
