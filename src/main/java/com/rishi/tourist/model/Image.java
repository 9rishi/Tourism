package com.rishi.tourist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name="image")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Image {

	//
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	public long id;
	//
   	@Column(length = 75)
   	public String fileName;
	//
	@Lob
	@Type(type = "org.hibernate.type.BinaryType")
	@Column(name="imagedata")
	public byte[] imageData;
	//
//	public long empId;
}
