package com.rishi.tourist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.rishi.tourist.util.Gender;
import com.rishi.tourist.util.StatusEnum;

import lombok.Data;

@Entity
@Table(name = "stud")
@Data
public class Student {

	//
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE,generator = "student_id_seq")
	@SequenceGenerator(name = "student_id_seq",sequenceName = "student_id_seq")
	long id;
	//
   	@Column(length = 75)
   	@OrderBy("name asc")
   	@NotBlank(message = "Name Mandatory, with min 3 and max 75 chars")
    @Size(min = 3,max = 75,message = "Name Mandatory, with min 3 and max 75 chars")
	String name;
	//
   	long weight;
   	//
	@Enumerated(EnumType.STRING)
	Gender gender;
	//
	@Enumerated(EnumType.STRING)
	StatusEnum status;
}
