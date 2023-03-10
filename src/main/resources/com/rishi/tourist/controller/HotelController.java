package com.rishi.tourist.controller;

import java.util.List;

import javax.validation.Valid;
import com.rishi.tourist.service.HotelService;

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

import com.rishi.tourist.model.Hotels;
import com.rishi.tourist.model.User;

@RestController
@RequestMapping("api/v1/hotel")
public class HotelController {
	
	//
	@Autowired
	HotelService hotelService;
	@GetMapping(path ="/hotel-name")
	public ResponseEntity<?> findByhotelName(@RequestParam(name = "hotelName") String hotelName) {

		List<Hotels> hotels1 = hotelService.findByhotelName(hotelName);
		return new ResponseEntity<>(hotels1, HttpStatus.OK);
	}
	@GetMapping(path = "/rate")
	public ResponseEntity<?> findMultipleTranposrtsByRating(@RequestParam(name ="rating") long rating) {
		try {
			return new ResponseEntity<>(hotelService.findMultipleTransportsByRating(rating),
					HttpStatus.OK);
		} catch (Exception e) {
			
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping(path = "/multipletransport/{rate}")
	public ResponseEntity<?> findMultipleAddressById(@PathVariable long rate) {
		try {
			return new ResponseEntity<>(hotelService.findMultipleTransportsByRating(rate),
					HttpStatus.OK);
		} catch (Exception e) {
			
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping(path="/city")
	public ResponseEntity<?> findByCity(@RequestParam(name="city")String city) {
		List<Hotels> hotels2= hotelService.findByCity(city);
		return new ResponseEntity<>(hotels2,HttpStatus.OK);
	}
   
}
