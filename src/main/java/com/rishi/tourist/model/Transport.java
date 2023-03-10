package com.rishi.tourist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name = "tourist_transport")
@Data
public class Transport {
	//
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "transport_id_seq")
	@SequenceGenerator(name = "transport_id_seq",sequenceName = "transport_id_seq")
	@NotNull
	long id;
	//
	@Column(length = 6, columnDefinition = "character(6)")
	@Size(min = 6)
	@NotNull(message = "vehicleNum is required")
	String vehicleNum;
	//
	
    @NotNull(message = "rating is required")
	long rating;
	//
	@Column(length = 75)
   	@NotBlank(message = "driverName Mandatory, with min 3 and max 75 chars")
    @Size(min = 3,max = 75,message = "driverName Mandatory, with min 3 and max 75 chars")
	String driverName;

}
