package com.rishi.tourist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rishi.tourist.model.Restaurants;
import com.rishi.tourist.service.RestaurantService;

@RestController
@RequestMapping("api/v1/restaurant")
public class RestaurantController {

	//
	@Autowired
	RestaurantService restaurantService;

	@GetMapping(path = "/restaurant-name")

	public ResponseEntity<?> findByrestaurantName(@RequestParam(name = "restaurantName") String restaurantName) {

		List<Restaurants> restaurants3 = restaurantService.findByrestaurantName(restaurantName);
		return new ResponseEntity<>(restaurants3, HttpStatus.OK);
	}

	@GetMapping(path = "/multipletransport/{rating}")
	public ResponseEntity<?> findByRating(@PathVariable long rating) {
		try {
			return new ResponseEntity<>(restaurantService.findByRating(rating), HttpStatus.OK);
		} catch (Exception e) {

			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(path = "/city")
	public ResponseEntity<?> findByCity(@RequestParam(name = "city") String city) {
		List<Restaurants> restaurants5 = restaurantService.findByCity(city);
		return new ResponseEntity<>(restaurants5, HttpStatus.OK);
	}
}
