package com.multicasa.multicasabackend.Services;

import com.multicasa.multicasabackend.Entities.User;
import com.multicasa.multicasabackend.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User login(String username, String password) {
        return userRepository.findByUsernameAndPass(username, password);
    }
}
