package com.rishi.tourist.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rishi.tourist.model.FeedBack;
import com.rishi.tourist.service.FeedBackService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/feedback")
public class FeedBackController {
	
	//
	@Autowired
	FeedBackService feedBackService;

	@PostMapping
	public ResponseEntity<?> createFeedBack(@Valid @RequestBody FeedBack feedBack) {

		FeedBack feedBack1 = feedBackService.saveFeedBack(feedBack);
		return new ResponseEntity<>(feedBack1, HttpStatus.OK);
	}

	@GetMapping(path = "/overallresponse")
	public ResponseEntity<?> findByOverall (@RequestParam(name = "overall") String overall){
		List<FeedBack> feed = feedBackService.findByOverall(overall);
		return  new ResponseEntity<>(feed,HttpStatus.OK); 
}
}