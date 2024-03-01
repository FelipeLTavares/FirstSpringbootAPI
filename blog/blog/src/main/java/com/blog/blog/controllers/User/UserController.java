package com.blog.blog.controllers.User;

import org.springframework.web.bind.annotation.RestController;

import com.blog.blog.dtos.User.CreateUSerDto;
import com.blog.blog.entities.User;
import com.blog.blog.services.UserService;

import jakarta.validation.Valid;

import java.util.List;

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
    public ResponseEntity<List<User>> findAll() {
        List<User> allUsers = userService.findAll();

        return ResponseEntity.ok(allUsers);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody CreateUSerDto requestData) {
        User user = new User(requestData);

        User createdUser = userService.create(user);

        return ResponseEntity.ok(createdUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        userService.delete(id);

        return ResponseEntity.ok("Apagado!");
    }
}
