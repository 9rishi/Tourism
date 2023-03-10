package com.rishi.tourist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rishi.tourist.dao.ThingsToDoRepository;
import com.rishi.tourist.model.ThingsToDo;

@Service
public class ThingsToDoService {

	//
	@Autowired
	ThingsToDoRepository thingsToDoRepository;
	
	public ThingsToDo saveThingsTodo(ThingsToDo thingsToDo) {
		
		return thingsToDoRepository.save(thingsToDo);
	}

}
