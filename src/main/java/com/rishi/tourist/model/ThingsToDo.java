package com.rishi.tourist.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Table(name = "tourist_thingstodo")
@Entity
public class ThingsToDo {
		
	//
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long id;
	@Column(length = 100)
	@NotNull(message = "task1 shouldn't be empty")
	@Size(min = 10)
	String task1;
	//
	Date completeTask1by;
	//
	@Column(length = 100)
	@NotNull(message = "task2 shouldn't be empty")
	@Size(min = 10)
	String task2 ;
	//
	Date completeTask2by;

}
