package com.rishi.tourist.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rishi.tourist.model.Stay;

@Repository
public interface StayRepository extends JpaRepository<Stay,Long> {

}
