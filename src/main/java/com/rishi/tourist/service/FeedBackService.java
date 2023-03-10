package com.rishi.tourist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rishi.tourist.dao.FeedBackRepository;
import com.rishi.tourist.model.FeedBack;

@Service
public class FeedBackService {

	//
	@Autowired
	FeedBackRepository feedBackRepository;
	public FeedBack saveFeedBack(FeedBack feedBack) {

		return feedBackRepository.save(feedBack);
	}
	public List<FeedBack> findByOverall (String overall ){
		return feedBackRepository.findByOverall(overall);
	}
}
