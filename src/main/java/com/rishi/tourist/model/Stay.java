package com.rishi.tourist.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name = "tourist_stay")
@Data
public class Stay {
	//
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE,generator = "stay_id_seq")
	@SequenceGenerator(name = "stay_id_seq",sequenceName = "stay_id_seq")
	long id;
	
	//
	Date checkIn;
	//
	Date checkOut;
	//
	@OneToOne
	@JoinColumn(name = "stayUserId")                                 
	User user;
	//
	@OneToOne
	@JoinColumn(name = "stayhotelId")                                 
	Hotels hotels;
	//
	@OneToOne
	@JoinColumn(name = "stayrestaurantId")                                 
	Restaurants restaurants;
	//
	@OneToOne
	@JoinColumn(name = "stayattractionsId")                                 
	Attractions attractions;
	
}
