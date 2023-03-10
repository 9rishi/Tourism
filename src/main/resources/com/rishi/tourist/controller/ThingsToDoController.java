package com.rishi.tourist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rishi.tourist.model.ThingsToDo;
import com.rishi.tourist.service.ThingsToDoService;

@CrossOrigin(origins = "")
@RestController
@RequestMapping("/api/v1/ThingsToDo")

public class ThingsToDoController {
	
	//
	@Autowired
	ThingsToDoService thingsToDoService;
	
	@PostMapping
	public ResponseEntity<?> createThingsToDo( @RequestBody ThingsToDo thingsToDo){
		ThingsToDo t = thingsToDoService.saveThingsTodo(thingsToDo);
		return new ResponseEntity<>(t,HttpStatus.OK);
	}
	
	

}
