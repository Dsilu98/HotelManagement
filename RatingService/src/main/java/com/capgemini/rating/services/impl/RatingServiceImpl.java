package com.capgemini.rating.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capgemini.rating.Repositories.RatingRepository;
import com.capgemini.rating.entities.Rating;
import com.capgemini.rating.exceptions.ResourceNotFoundExceptions;
import com.capgemini.rating.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService {
	@Autowired
	private RatingRepository repository;

	@Override
	public Rating createRating(Rating rating) {
		String string = UUID.randomUUID().toString();
		rating.setRatingId(string);
		return repository.save(rating);
	}

	@Override
	public Rating updateRating(Rating ratingDetails) {
		return null;
	}

	@Override
	public Rating getRatingById(String id) {
		return repository.findById(id).orElseThrow(()->new ResourceNotFoundExceptions("Hotel not found with hotel id : "+id));
	}

	@Override
	public List<Rating> getRatings() {
		return repository.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String id) {
		return repository.findByUserId(id);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		return repository.findByHotelId(hotelId);
	}
	
}
