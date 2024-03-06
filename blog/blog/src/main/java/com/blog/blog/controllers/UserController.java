package com.blog.blog.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.blog.blog.dtos.User.CreateUSerDto;
import com.blog.blog.dtos.User.UpdateUserDto;
import com.blog.blog.dtos.User.UpdatedUserDto;
import com.blog.blog.entities.User;
import com.blog.blog.services.UserService;

import jakarta.transaction.Transactional;
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
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> allUsers = userService.findAll();

        return ResponseEntity.ok(allUsers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> findById(@PathVariable Long id) {
        Optional<User> user = userService.findById(id);

        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> create(@Valid @RequestBody CreateUSerDto requestData) {
        User user = new User(requestData);

        User createdUser = userService.create(user);

        return ResponseEntity.ok(createdUser);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<UpdatedUserDto> update(@RequestBody @Valid UpdateUserDto requestData) {
        User user = userService.update(requestData);

        return ResponseEntity.ok(new UpdatedUserDto(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        userService.delete(id);

        return ResponseEntity.ok("Apagado!");
    }
}
