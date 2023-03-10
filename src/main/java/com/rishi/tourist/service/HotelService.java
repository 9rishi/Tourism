package com.rishi.tourist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rishi.tourist.dao.HotelRepository;
import com.rishi.tourist.dao.TransportRepository;
import com.rishi.tourist.model.Hotels;
import com.rishi.tourist.model.Transport;

@Service
public class HotelService {
	
	//
	@Autowired
	HotelRepository hotelRepository;
	@Autowired
	TransportRepository transportRepository;
	
			
		public List<Hotels> findByhotelName(String hotelName) {
			return hotelRepository.findByhotelName(hotelName);
		}
		
		public List<Hotels> findMultipleTransportsByRating(long rate) throws Exception {
			Transport transport = transportRepository.findByrating(rate).get();
			if (transport != null)
				return hotelRepository.findMultipleTransportsByRating(rate);
			else {
				throw new Exception("Transport doesn't exist with rate:" + rate);
			}
	}
		 public List<Hotels> findByCity(String city){
			 return hotelRepository.findByCity(city);
		 }
		
}
