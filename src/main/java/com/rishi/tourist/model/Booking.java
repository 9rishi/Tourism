package com.rishi.tourist.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name = "touristbooking")
@Data

public class Booking {
	
	
	//
	@Column(length = 100)
	@NotNull(message = "bookType shouldn't be empty")
	@Size(min = 3)
	String bookType;
	
	//
	@Column(length = 100)
	//@NotNull(message = "date of booking shouldn't be empty")
	//@Size(min = 3)
	Date dateOfBooking;
	//
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE,generator = "booking_id_seq")
	@SequenceGenerator(name = "booking_id_seq",sequenceName = "booking_id_seq")
	long id;
	//
	@OneToOne
	@JoinColumn(name = "fk_userid")
	User user;
   // long id1;
	
}
