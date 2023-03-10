package com.rishi.tourist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
@Table(name = "touristfeedback")
public class FeedBack {
	
	//
	@Id
	@Column(length = 100)
	@NotNull(message = "response shouldn't be empty")
	@Size(min = 10)
	String response;
	//
	@Column(length = 10,columnDefinition = "character(10)")
	@NotBlank(message = "phone number is required")
	@Size(min = 10,max=10,message =" phone num should contain 10 nos")
	String phoneNum;
	//
	@Column(length = 75)
	@Email
	@NotBlank(message = "email is required")
	String email;
	//
	@Column(length=50)
	@NotNull(message = "shouldn't be empty")
	@Size(min =2)
	String overall;   //it shld be good or bad only
	
}
