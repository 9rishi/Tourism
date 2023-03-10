package com.rishi.tourist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rishi.tourist.model.Attractions; //
import com.rishi.tourist.service.AttractionService;

@RestController

@RequestMapping("api/v1/attractions")

public class AttractionsController {

	//
	@Autowired
	AttractionService attractionService;

	@GetMapping(path = "/attraction-name")
	public ResponseEntity<?> findByattractionName(@RequestParam(name = "attractionName") String attractionName) {

		List<Attractions> attractions1 = attractionService.findByattractionName(attractionName);
		return new ResponseEntity<>(attractions1, HttpStatus.OK);
	}

	@GetMapping(path = "/multipletransport/{rate}")
	public ResponseEntity<?> findMultipleTransportsById(@PathVariable long rate) {
		try {
			return new ResponseEntity<>(attractionService.findMultipleTransportsByRating(rate), HttpStatus.OK);
		} catch (Exception e) {

			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

}
