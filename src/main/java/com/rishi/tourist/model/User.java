package com.rishi.tourist.model;

import java.util.List;

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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.rishi.tourist.util.Gender;
import com.rishi.tourist.util.StatusEnum;

import lombok.Data;

@Entity
@Table(name = "tourist_user")
@Data

public class User {
 
	//
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE,generator = "user_id_seq")
	@SequenceGenerator(name = "user_id_seq",sequenceName = "user_id_seq")
	public long id;
	//
   	@Column(length = 75)
   	@OrderBy("firstName asc")
   	@NotBlank(message = "First Name Mandatory, with min 3 and max 75 chars")
    @Size(min = 3,max = 75,message = "First Name Mandatory, with min 3 and max 75 chars")
	public String firstName;
	//
	@Column(length = 75)
	@NotFound(action = NotFoundAction.IGNORE)
	@Size(min = 3,max = 75,message = "Middle Name Mandatory, with min 3 and max 75 chars")
	String middleName;
	//
	@Column(length = 75)
	@NotBlank(message = "Last Name Mandatory, with min 3 and max 75 chars")
    @Size(min = 3,max = 75,message = "Last Name Mandatory, with min 3 and max 75 chars")
	String lastName;
	//
	@Enumerated(EnumType.STRING)
	public Gender gender;
	//
	@Enumerated(EnumType.STRING)
	public StatusEnum status; 
	//
	@Column(length = 10,columnDefinition = "character(10)")
	@NotBlank(message = "phone number is required")
	@Size(min = 10,max=10,message =" phone num should contain 10 nos")
	public String phoneNum;
	//
	@Column(length = 75)
	@Email
	@NotBlank(message = "email is required")
    // @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
	public String email;
	//
	@Size(min = 3,max = 75,message = "Password Mandatory, with min 3 and max 75 chars")
	public String password;
	//
	public String filePath;

	
}
