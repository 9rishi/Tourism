package com.rishi.tourist.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rishi.tourist.model.Booking;
import com.rishi.tourist.service.BookingService;
import com.rishi.tourist.service.UserService;
@RestController
@RequestMapping("api/v1/booking")
public class BookingController {

	//
	@Autowired
	BookingService bookingService;
	//
	@Autowired
	UserService userService;
	
	@PostMapping

	public ResponseEntity<?> createBooking( @RequestBody Booking booking) {
		
		Booking booking2= userService.saveBooking(booking);
		return new ResponseEntity<>(booking2,HttpStatus.OK);
	}

}