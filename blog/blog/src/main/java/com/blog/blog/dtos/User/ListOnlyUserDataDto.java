package com.blog.blog.dtos.User;

import com.blog.blog.entities.User;

public record ListOnlyUserDataDto (String name) {
    
    public ListOnlyUserDataDto ( User user ) {
        this(user.getName());
    }

}
