package com.capgemini.rating.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.rating.Repositories.RatingRepository;
import com.capgemini.rating.entities.Rating;
import com.capgemini.rating.services.impl.RatingServiceImpl;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	
	@Autowired
	public RatingServiceImpl impl;
	
	@PostMapping("/")
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
		return ResponseEntity.created(null).body(impl.createRating(rating));
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Rating>> getRatings(){
		return ResponseEntity.ok(impl.getRatings());
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<List<Rating>> getRaingByUserId(@PathVariable String id){
		return ResponseEntity.ok(impl.getRatingByUserId(id));
	}
	
	@GetMapping("/hotels/{id}")
	public ResponseEntity<List<Rating>> getRaingByHotelId(@PathVariable String id){
		return ResponseEntity.ok(impl.getRatingByHotelId(id));
	}
}
