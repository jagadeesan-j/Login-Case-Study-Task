package com.login.service;

import com.login.Request;
import com.login.entity.User;
import com.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public boolean register(Request request) {

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        if (user != null) {
            userRepository.save(user);
            return true;
        } else {
            return false;
        }
    }

    public Boolean login(Request request) {

        Optional<User> user = Optional.ofNullable(userRepository.findByUsername(request.getUsername()));

        if (user.isEmpty()) {
            return false;
        }

        String password = passwordEncoder.encode(request.getPassword());
        User userFromDB = userRepository.findByUsername(request.getUsername());

        if (password == userFromDB.getPassword()) {
            return true;
        }
        return false;
    }
}
