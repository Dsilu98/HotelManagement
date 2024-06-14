package com.capgemini.user.service.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capgemini.user.service.entities.Hotel;
import com.capgemini.user.service.entities.Rating;
import com.capgemini.user.service.entities.User;
import com.capgemini.user.service.exceptions.ResourceNotFoundexception;
import com.capgemini.user.service.external.services.HotelService;
import com.capgemini.user.service.repositories.UserRepository;
import com.capgemini.user.service.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository repository;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private HotelService hotelService;
	
	@Override
	public User createUser(User user) {
		String randomUserId=UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		
		return repository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		List<User> users = repository.findAll();
		
		return users;
	}

	@Override
	public User getUser(String userId) {
		
		User user= repository.findById(userId).orElseThrow(()->new ResourceNotFoundexception("User not found with user id : "+userId));
		
		//fetch rating of the above user from RATINGSERVICE
		//http://localhost:8083/ratings/users/5c74d640-ff32-49f9-90e0-51f35fdd35ee
		
		Rating[] ratingsOfUSer = restTemplate.getForObject("http://RATINGSERVICE/ratings/users/"+userId, Rating[].class);
		List<Rating> ratingList = Arrays.stream(ratingsOfUSer).toList();
		
		ratingList.stream().map(rating->{
//		ResponseEntity<Hotel>	hotelResponce=restTemplate.getForEntity("http://HOTELSERVICE/hotels/hotelid/"+rating.getHotelId(),Hotel.class);
//		Hotel hotel = hotelResponce.getBody();
			
		Hotel hotel = hotelService.getHotel(rating.getHotelId());
		rating.setHotel(hotel);
		
		return new Rating();
		}).collect(Collectors.toList());
		
		user.setRatings(ratingList);
		
		return user;
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
