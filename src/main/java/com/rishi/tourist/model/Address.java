	package com.rishi.tourist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import lombok.Data;

@Entity
@Data
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "add_seq")
	@SequenceGenerator(name = "add_seq", sequenceName = "add_seq")
	long id;
	//
	@Column(length = 100)
	@NotNull(message = "addressline1 shouldn't be empty")
	@Size(min = 10)
	String addressLine1;
	//
	@Column(length = 100)
	@NotFound(action = NotFoundAction.IGNORE)
	String addressLine2;
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
	@JoinColumn(name = "userId")                                 //(name = "userId",unique = true) if user has to hav 1 single address
	User user;
	//

}
