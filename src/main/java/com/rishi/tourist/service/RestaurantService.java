package com.rishi.tourist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rishi.tourist.dao.RestaurantRepository;
import com.rishi.tourist.dao.TransportRepository;
import com.rishi.tourist.model.Attractions;
import com.rishi.tourist.model.Hotels;
import com.rishi.tourist.model.Restaurants;
import com.rishi.tourist.model.Transport;

@Service
public class RestaurantService {

	//
	@Autowired
	RestaurantRepository restaurantRepository;
	@Autowired
	TransportRepository transportRepository;

	

	public List<Restaurants> findByrestaurantName(String restaurantName) {
		return restaurantRepository.findByrestaurantName(restaurantName);
	}
	
	public List<Restaurants> findByRating(long rating) throws Exception  {
		Transport transport = transportRepository.findByrating(rating).get();
		if (transport != null)
			return restaurantRepository.findByRating(rating);
		else {
			throw new Exception("Transport doesn't exist with rate:" + rating);
		}
	}
	public List<Restaurants> findByCity(String city){
		return restaurantRepository.findBycity(city);
	}
	
}
