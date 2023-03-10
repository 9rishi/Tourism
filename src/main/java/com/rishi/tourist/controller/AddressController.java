package com.rishi.tourist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rishi.tourist.service.AddressService;
import com.rishi.tourist.service.UserService;

@RestController
@CrossOrigin(origins = "")
@RequestMapping("api/v1/address")
public class AddressController {

	//
	@Autowired
	AddressService addressService;
	
	//
	@Autowired
	UserService userService;
     //
	//@PostMapping
	//public ResponseEntity<?> createAddress(@RequestBody Address address){
		//Address  user2= userService.saveAddress(address); 
//	return new ResponseEntity<>(user2,HttpStatus.OK);
  
  }

