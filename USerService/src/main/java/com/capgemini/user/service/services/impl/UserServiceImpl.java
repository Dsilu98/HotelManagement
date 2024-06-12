package com.capgemini.user.service.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.user.service.entities.User;
import com.capgemini.user.service.exceptions.ResourceNotFoundexception;
import com.capgemini.user.service.repositories.UserRepository;
import com.capgemini.user.service.services.UserService;

@Service
public class UserServiceImpl implements UserService{
@Autowired
private UserRepository repository;
	
	@Override
	public User createUser(User user) {
		String randomUserId=UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		
		return repository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return repository.findAll();
	}

	@Override
	public User getUser(String userId) {
		return repository.findById(userId).orElseThrow(()->new ResourceNotFoundexception("User not found with user id : "+userId));
	}

	@Override
	public User updateUser(String id, User userDetails) {
		Optional<User> optionalUser = repository.findById(id);
		if(optionalUser.isPresent()) {
			User existingUser = optionalUser.get();
			existingUser.setName(userDetails.getName());
			existingUser.setEmail(userDetails.getEmail());
			existingUser.setAbout(userDetails.getAbout());
			return repository.save(existingUser);
		}
		else {
			throw new ResourceNotFoundexception("User not found with id : "+id);
		}
	}



}
