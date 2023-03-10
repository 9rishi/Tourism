package com.rishi.tourist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.rishi.tourist.dao.ExploreRepository;
import com.rishi.tourist.model.Explore;

@Service
public class ExploreService {

	//
	@Autowired
	ExploreRepository exploreRepository;
	
	
	public Explore saveExplore(Explore explore) {
		
		return exploreRepository.save(explore);
	}

}
