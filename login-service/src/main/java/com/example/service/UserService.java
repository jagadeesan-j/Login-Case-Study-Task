package com.example.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.entity.Request;
import com.example.entity.User;
import com.example.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	UserRepository userRepository;

	public void register(Request request) {
		
		User user = new User();
		
		user.setUsername(request.getUsername());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		
//		    		(User) User.builder()
//		        .username(request.getUsername())
//		        .password(passwordEncoder.encode(request.getPassword()))
//		        .roles("USER")
//		        .build();
		
		if (user != null) {
			userRepository.save((User) user);
		}
	}

	public Boolean login(Request request) {
		
		Optional<User> user = null;
		
		user = userRepository.findById(request.getUsername());
		if (user == null) {
			return false;
		}
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		if (encoder.matches(request.getPassword(), user.get().getPassword())) {
			return true;
		}
		return false;
	}

}
