
package com.rishi.tourist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rishi.tourist.dao.AttractionRepository;
import com.rishi.tourist.dao.TransportRepository;
import com.rishi.tourist.model.Attractions;
import com.rishi.tourist.model.Hotels;
import com.rishi.tourist.model.Restaurants;
import com.rishi.tourist.model.Transport;
@Service
public class AttractionService {

	// 
	@Autowired
	TransportRepository transportRepository;

	@Autowired
	AttractionRepository attractionRepository;


	public List<Attractions> findByattractionName(String attractionName) {
		return attractionRepository.findByattractionName(attractionName);
	}
	
	public List<Attractions> findMultipleTransportsByRating(long rate) throws Exception {
		Transport transport = transportRepository.findByrating(rate).get();
		if (transport != null)
			return attractionRepository.findMultipleTransportsByRating(rate);
		else {
			throw new Exception("Transport doesn't exist with rate:" + rate);
		}
	}

}
