package com.rishi.tourist.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rishi.tourist.model.Restaurants;
@Repository

public interface RestaurantRepository extends JpaRepository<Restaurants, Long> {
	
	List<Restaurants> findByrestaurantName(String restaurantName);

	List<Restaurants> findByRating (long rating);

	List<Restaurants> findBycity(String city);

}
