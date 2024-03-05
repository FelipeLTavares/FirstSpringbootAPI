package com.blog.blog.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.blog.dtos.User.ListOnlyUserDataDto;
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

    public Optional<User> findById(Long id) {
        Optional<User> user = userRepository.findById(id);

        return user;
    }

    public List<ListOnlyUserDataDto> getUsersList () {
        return userRepository.findAll().stream().map(ListOnlyUserDataDto::new).toList();
    }

    public User create(User userData) {
        User createdUser = userRepository.save(userData);

        return createdUser;
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
