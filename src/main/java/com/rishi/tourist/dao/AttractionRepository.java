
package com.rishi.tourist.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rishi.tourist.model.Attractions;

@Repository
public interface AttractionRepository extends JpaRepository<Attractions, String> {

	List<Attractions> findByattractionName(String attractionName);

	List<Attractions> findMultipleTransportsByRating(long rate);

}
