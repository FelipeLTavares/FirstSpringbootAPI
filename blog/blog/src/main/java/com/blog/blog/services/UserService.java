package com.blog.blog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.blog.blog.dtos.User.UpdateUserDto;
import com.blog.blog.entities.User;
import com.blog.blog.repositories.UserRepository;

import jakarta.validation.Valid;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Page<User> findAll(Pageable pageable) {
        Page<User> allUsers = userRepository.findAll(pageable);

        return allUsers;
    }

    public User findById(Long id) {
        User user = userRepository.getReferenceById(id);

        return user;
    }

    public User create(User user) {
        User createdUser = userRepository.save(user);

        return createdUser;
    }

    public User update(@Valid UpdateUserDto updateData) {
        User user = userRepository.getReferenceById(updateData.id());

        if (updateData.name() != null) {
            user.setName(updateData.name());
        }

        return user;
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
