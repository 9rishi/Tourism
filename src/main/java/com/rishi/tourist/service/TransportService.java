package com.rishi.tourist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rishi.tourist.dao.AttractionRepository;
import com.rishi.tourist.dao.HotelRepository;
import com.rishi.tourist.dao.RestaurantRepository;
import com.rishi.tourist.dao.TransportRepository;
import com.rishi.tourist.model.Attractions;
import com.rishi.tourist.model.Hotels;
import com.rishi.tourist.model.Restaurants;
import com.rishi.tourist.model.Transport;

@Service

public class TransportService {

	//
	@Autowired
	TransportRepository transportRepository;
	@Autowired
	RestaurantRepository restaurantRepository;
	@Autowired
	HotelRepository hotelRepository;
	@Autowired
	AttractionRepository attractionRepository;

	public Transport saveTransport(Transport transport) {
		return transportRepository.save(transport);
	}

	public Restaurants saveRestaurant(Restaurants restaurants) {
		Restaurants restaurants1 = new Restaurants();
		Optional<Transport> trans = transportRepository.findByrating(restaurants.getTransport().getRating());
		if (trans.isPresent()) {
			restaurants1.setTransport(trans.get());
	}
	restaurants1 = restaurantRepository.save(restaurants);
		return restaurants1;
	}

	public Hotels saveHotel(Hotels hotel1) {
		Hotels hotels2 = new Hotels();
		Optional<Transport> trans = transportRepository.findById(hotel1.getTransport().getRating());
		if (trans.isPresent()) {
			hotels2.setTransport(trans.get());
	}
		hotels2 = hotelRepository.save(hotel1);
		return hotels2;
	}
    
	public Attractions saveAttraction(Attractions attraction1) {
		Attractions attractions2 = new Attractions();
		Optional<Transport> trans = transportRepository.findById(attraction1.getTransport().getRating());
		if (trans.isPresent()) {
			attractions2.setTransport(trans.get());
		}
		attractions2 = attractionRepository.save(attraction1);
		return attractions2;
	}

	public Optional<Transport> findByrating(Long rating) {
		return transportRepository.findByrating(rating);
	}

}
