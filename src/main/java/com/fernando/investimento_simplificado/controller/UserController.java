package com.fernando.investimento_simplificado.controller;


import com.fernando.investimento_simplificado.dtos.CreateUserDto;
import com.fernando.investimento_simplificado.dtos.UpdateUserDto;
import com.fernando.investimento_simplificado.entity.User;
import com.fernando.investimento_simplificado.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("v1/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody CreateUserDto createUserDto) {
        var UserId = service.createUser(createUserDto);
        return ResponseEntity.created(URI.create("/v1/users/" + UserId.toString())).build();

    }

    ;


    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") String userId) {
        var user = service.getUserById(userId);

        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<User>> listUsers() {
        var users = service.listUsers();
        if (users.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(users);
        }
    }


    @PutMapping("/{userId}")
    public ResponseEntity<Void> updateUserById(@PathVariable("userId") String userId,
                                               @RequestBody UpdateUserDto updateUserDto) {
        service.updateUserById(userId, updateUserDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{userId}")
    public ResponseEntity<Void> deleteUsers(@PathVariable String userId) {
        service.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
}
