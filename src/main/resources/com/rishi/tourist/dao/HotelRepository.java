package com.rishi.tourist.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rishi.tourist.model.Hotels;
import com.rishi.tourist.model.Transport;

@Repository
public interface HotelRepository extends JpaRepository<Hotels, String>{
	List<Hotels> findByhotelName(String hotelName);

	List<Hotels> findMultipleTransportsByRating(long rate);

	List<Hotels> findByCity(String city);


}
