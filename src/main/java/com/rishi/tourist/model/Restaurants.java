package com.rishi.tourist.model;

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
@Table(name = "touristrestaurants")
@Data
public class Restaurants {

	//
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "res_seq")
	@SequenceGenerator(name = "res_seq", sequenceName = "res_seq")
	long id;

	//
	@Column(length = 100)
	@NotNull(message = "restaurantName shouldn't be empty")
	@Size(min = 10)
	String restaurantName;

	//
	@Column(length = 100)
	@NotNull(message = "addressline shouldn't be empty")
	@Size(min = 10)
	String addressLine;

	//
	@Column(length = 1, columnDefinition = "character(1)")
	@Size(min = 1)
	@NotNull(message = "rating is required")
	String rating;

	//
	@Column(length = 70)
	@NotNull(message = "city is required")
	@Size(min = 3)
	String city;

	//
	@Column(length = 70)
	@NotNull(message = "state is required")
	@Size(min = 3)
	String state;

	//
	@Column(length = 100)
	@NotNull(message = "country is required")
	String country;

	//
	@Column(length = 6, columnDefinition = "character(6)")
	@Size(min = 6)
	@NotNull(message = "zip is required")
	String zip;

	//
	@OneToOne
	@JoinColumn(name = "transport_id")
	Transport transport;

}