package com.rishi.tourist.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rishi.tourist.model.Transport;

@Repository
public interface TransportRepository extends JpaRepository<Transport, Long> {
	
	//List<Transport> findByrating(String rating);

	Optional<Transport> findByrating(long rate);


}



      



