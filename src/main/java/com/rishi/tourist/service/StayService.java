package com.rishi.tourist.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rishi.tourist.dao.StayRepository;
import com.rishi.tourist.dao.UserRepository;
import com.rishi.tourist.model.Stay;
import com.rishi.tourist.model.User;

@Service
public class StayService {

	//
	@Autowired
	StayRepository stayRepository;
	//
	@Autowired
	UserRepository userRepository;
	
	public Stay saveStay(Stay stay) {
		Stay stay1 = new Stay();
		Optional<User> user =userRepository.findById(stay.getUser().getId());
		if(user.isPresent()) {
			stay1.setUser(user.get());
		}
		stay1 = stayRepository.save(stay);
		return stay1;
	}

}
