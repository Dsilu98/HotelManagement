package com.capgemini.HotelService.services;

import java.util.List;

import com.capgemini.HotelService.entity.Hotel;

public interface HotelService {
	//create hotel
	Hotel createHotel(Hotel hotel);
	//update hotel
	Hotel updatHotel(String id,Hotel hotelDetails);
	//delete hotel
	//get hotel by id
	Hotel getHotelById(String id);
	//get all hotels
	List<Hotel> getAllHotel();
}
