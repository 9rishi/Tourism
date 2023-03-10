package com.rishi.tourist.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rishi.tourist.model.Attractions;
import com.rishi.tourist.model.Hotels;
import com.rishi.tourist.model.Restaurants;
import com.rishi.tourist.model.Transport;
import com.rishi.tourist.service.AttractionService;
import com.rishi.tourist.service.RestaurantService;
import com.rishi.tourist.service.TransportService;

@RestController
@RequestMapping("api/v1/transport")
public class TransportController {

	//
	@Autowired
	TransportService transportService;
	@Autowired
	RestaurantService restaurantService;
	@Autowired
	AttractionService attractionService;

	//
	@PostMapping
	public ResponseEntity<?> createTransport(@RequestBody Transport transport) {

		Transport trans = transportService.saveTransport(transport);
		return new ResponseEntity<>(trans, HttpStatus.OK);
	}

	@PostMapping(path = "/restaurants")

	public ResponseEntity<?> createRestaurant(@RequestBody Restaurants restaurants) {
		Restaurants restaurants2 = transportService.saveRestaurant(restaurants);
		return new ResponseEntity<>(restaurants2, HttpStatus.OK);
	}

	@PostMapping(path = "/hotels")

	public ResponseEntity<?> createHotel(@Valid @RequestBody Hotels hotel) {

		Hotels hotel1 = transportService.saveHotel(hotel);
		return new ResponseEntity<>(hotel1, HttpStatus.OK);
	}

	@PostMapping(path = "/attractions")
	public ResponseEntity<?> createAttractions(@Valid @RequestBody Attractions attractions) {

		Attractions attractions1 = transportService.saveAttraction(attractions);
		return new ResponseEntity<>(attractions1, HttpStatus.OK);

	}

	@GetMapping(path = "/rating")
	public ResponseEntity<?> findByrating(@RequestParam(name = "rating") Long rating) {

		Optional<Transport> trans1 = transportService.findByrating(rating);
		
		return new ResponseEntity<>(trans1, HttpStatus.OK);
	}
}
