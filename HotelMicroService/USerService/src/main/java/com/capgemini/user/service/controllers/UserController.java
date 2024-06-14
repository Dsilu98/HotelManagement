package com.capgemini.user.service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.user.service.entities.User;
import com.capgemini.user.service.services.impl.UserServiceImpl;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserServiceImpl serviceImpl;
	
	@PostMapping("/")
	public User createUser(@RequestBody User user) {
		return serviceImpl.createUser(user);
	}
	
	@GetMapping("/userid/{id}")
	public User getUserById(@PathVariable  String id) {
		return serviceImpl.getUser(id);
	}
	
	@GetMapping("/")
	public List<User> getAllUser() {
		return serviceImpl.getAllUser();
	}
	
	@PutMapping("/update/{id}")
	public User updateUserByID(@PathVariable String id, @RequestBody User user) {
		return serviceImpl.updateUser(id, user);
	}
	
}
