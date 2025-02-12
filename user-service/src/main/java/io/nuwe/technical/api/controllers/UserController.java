package io.nuwe.technical.api.controllers;

import io.nuwe.technical.api.entities.*;
import io.nuwe.technical.api.services.*;
import io.nuwe.technical.api.grpc.GrpcClientService;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;

@RestController
public class UserController {

	/* TODO TASK 1: complete the methods */

    @Autowired
    private UserService userService;

    @Autowired
    private GrpcClientService grpcClientService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){}

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int id){}

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user){}

    @DeleteMapping("/user/{id}")
    public ResponseEntity<User> deleteUserById(@PathVariable("id") int id){}

    @DeleteMapping("/user/all")
    public ResponseEntity<User> deleteAllUsers(){}
}
