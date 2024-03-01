package com.blog.blog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.blog.entities.User;
import com.blog.blog.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> findAll() {
        List<User> allUsers = userRepository.findAll();

        return allUsers;
    }

    public User create(User userData) {
        User createdUser = userRepository.save(userData);

        return createdUser;
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
