package com.capgemini.HotelService.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.HotelService.entity.Hotel;
import com.capgemini.HotelService.services.impl.HotelServiceImpl;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	@Autowired
	private HotelServiceImpl serviceImpl;
	
	@PostMapping("/")
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
		return ResponseEntity.status(HttpStatus.CREATED).body(serviceImpl.createHotel(hotel));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Hotel> updateHotel(@PathVariable String id, @RequestBody Hotel hoteldetails) {
		return ResponseEntity.status(HttpStatus.OK).body(serviceImpl.updatHotel(id, hoteldetails));
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Hotel>> getAllHotels(@RequestBody Hotel hotel){
		return ResponseEntity.ok(serviceImpl.getAllHotel());
	}
	@GetMapping("/hotelid/{id}")
	public ResponseEntity<Hotel> getHotelByID(@PathVariable String id) {
		return ResponseEntity.ok(serviceImpl.getHotelById(id));
	}
}
