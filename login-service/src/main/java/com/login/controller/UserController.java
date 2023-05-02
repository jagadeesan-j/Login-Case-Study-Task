package com.login.controller;

import com.login.Request;
import com.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody Request request) {
        userService.register(request);
        return "Registered.";
    }

    @PostMapping("/login")
    public String login(@RequestBody Request request) {

        Boolean login = userService.login(request);

        if (login == true)
            return "Login Successful";
        else
            return "Login Failed";
    }
}
