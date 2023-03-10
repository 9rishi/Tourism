package com.rishi.tourist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rishi.tourist.dao.BookingRepository;
import com.rishi.tourist.model.Booking;

@Service

public class BookingService {
	//
	@Autowired
	BookingRepository bookingRepository;


	}

	