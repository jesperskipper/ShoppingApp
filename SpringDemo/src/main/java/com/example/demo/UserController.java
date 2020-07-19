package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Scanner;

@RestController
@CrossOrigin(origins = "http://localhost:4200") // This step isn't always necessary. Since we are deploying our Angular frontend to http://localhost:4200 and our Boot backend to http://localhost:8080, the browser would otherwise deny requests from one to the other.
public class UserController {

    private UserRepository userRepository;

    public UserController() {
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return (List<User>) userRepository.findAll();
    }

    @PostMapping("/users")
    void addUser(@RequestBody User user){
        userRepository.save(user);
    }


}
