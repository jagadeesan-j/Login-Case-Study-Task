package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Request;
import com.example.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {
	
	@Autowired
	UserService service;
	
	@PostMapping("/register")
	public Request register(@RequestBody Request user) {
		service.register(user);
		return user;
	}
	
	@PostMapping("/login")
	public Request login(@RequestBody Request user) {
		
		Boolean log=service.login(user);
//		System.out.println(log);
		if(log==true)
			return user;
		else
			return null;
	}
}
