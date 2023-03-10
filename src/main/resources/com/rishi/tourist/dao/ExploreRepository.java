package com.rishi.tourist.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rishi.tourist.model.Explore;

@Repository
public interface ExploreRepository extends JpaRepository<Explore,Long> {

}
