package com.rishi.tourist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rishi.tourist.model.Stay;
import com.rishi.tourist.service.StayService;

@RestController
@CrossOrigin(origins = "")
@RequestMapping("api/v1/stay")
public class StayController {
	
	//
	@Autowired
	StayService stayService;

	//
	@PostMapping
	public ResponseEntity<?> createStay(@RequestBody Stay stay) {
		Stay st = stayService.saveStay(stay);
		return new ResponseEntity<>(st,HttpStatus.OK);
		
	}

}
