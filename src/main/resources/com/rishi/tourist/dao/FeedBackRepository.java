package com.rishi.tourist.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rishi.tourist.model.FeedBack;
@Repository
public interface FeedBackRepository extends JpaRepository<FeedBack,String> {

	List<FeedBack> findByOverall(String overall);




	


}
