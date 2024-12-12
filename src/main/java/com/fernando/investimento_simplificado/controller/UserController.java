package com.fernando.investimento_simplificado.controller;


import com.fernando.investimento_simplificado.dtos.CreateUserDto;
import com.fernando.investimento_simplificado.entity.User;
import com.fernando.investimento_simplificado.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("v1/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody CreateUserDto createUserDto) {
        var UserId = service.createUser(createUserDto);
        return ResponseEntity.created(URI.create("/v1/users/" + UserId.toString())).build();

    };


    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@RequestBody String userId) {
        var user = service.getUserById(userId);

        if(user.isPresent()){
            ResponseEntity.ok(user.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    };

}
