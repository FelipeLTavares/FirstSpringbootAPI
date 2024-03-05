package com.blog.blog.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.blog.blog.dtos.User.CreateUSerDto;
import com.blog.blog.dtos.User.ListOnlyUserDataDto;
import com.blog.blog.entities.User;
import com.blog.blog.services.UserService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<ListOnlyUserDataDto>> findAll() {
        List<ListOnlyUserDataDto> allUsers = userService.getUsersList();

        return ResponseEntity.ok(allUsers);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Optional<User>> findUserAndPosts(@PathVariable Long id) {
        Optional<User> allUsers = userService.findById(id);

        return ResponseEntity.ok(allUsers);
    }

    @PostMapping
    public ResponseEntity<User> create(@Valid @RequestBody CreateUSerDto requestData) {
        User user = new User(requestData);

        User createdUser = userService.create(user);

        return ResponseEntity.ok(createdUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        userService.delete(id);

        return ResponseEntity.ok("Apagado!");
    }
}
