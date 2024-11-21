package com.multicasa.multicasabackend.Controllers;

import com.multicasa.multicasabackend.Entities.User;
import com.multicasa.multicasabackend.Repositories.UserRepository;
import com.multicasa.multicasabackend.Services.UserService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public ResponseEntity<User> login(@RequestParam String username, @RequestParam String password) {
        User user = userService.login(username, password);
        if (user != null) {
            Hibernate.initialize(user.getRole());
        }
        return ResponseEntity.ok(user);
    }

}
