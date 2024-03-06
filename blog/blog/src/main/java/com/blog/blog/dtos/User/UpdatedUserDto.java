package com.blog.blog.dtos.User;

import com.blog.blog.entities.User;

public record UpdatedUserDto(Long id, String name) {

    public UpdatedUserDto(User user) {
        this(user.getId(), user.getName());
    }

}
