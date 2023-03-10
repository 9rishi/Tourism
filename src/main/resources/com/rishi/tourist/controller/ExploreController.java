package com.rishi.tourist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rishi.tourist.model.Explore;
import com.rishi.tourist.service.ExploreService;

@RestController
@RequestMapping("api/v1/explore")
@CrossOrigin(origins = "")
public class ExploreController {

	//
	@Autowired
	ExploreService exploreService;
	@PostMapping
	public ResponseEntity<?> createExplore(Explore explore){
		Explore e = exploreService.saveExplore(explore);
		return new ResponseEntity<>(e,HttpStatus.OK);
	}
}
