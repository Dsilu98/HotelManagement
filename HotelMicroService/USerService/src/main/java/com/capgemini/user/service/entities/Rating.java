package com.capgemini.user.service.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
	private String ratingId;
	private String userId;
	private String hotelId;
	private Hotel hotel;
	private Integer rating;
	private String feedback;
	
}
