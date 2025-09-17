package io.nuwe.technical.api.controllers;

import io.nuwe.technical.api.entities.*;
import io.nuwe.technical.api.services.*;
import io.nuwe.technical.api.grpc.GrpcClientService;

import java.net.URI;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

import org.hibernate.type.descriptor.java.ObjectArrayJavaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    private final GrpcClientService grpcClientService;

    public UserController(UserService userService, GrpcClientService grpcClientService) {
        this.userService = userService;
        this.grpcClientService = grpcClientService;
    }

    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody User user){
        User u = userService.createUser(user);
        return u == null ? ResponseEntity.badRequest().build() : ResponseEntity.created(URI.create("/user/" + u.getId())).body(null);
    }

    @GetMapping("all")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        if(users.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(users);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int id){
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<User> deleteUserById(@PathVariable("id") int id){
        if(userService.getUserById(id).isPresent()){
            User user = userService.getUserById(id).get();
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("all")
    public ResponseEntity<User> deleteAllUsers(){
        userService.deleteAll();
        return ResponseEntity.ok().build();
    }
}

