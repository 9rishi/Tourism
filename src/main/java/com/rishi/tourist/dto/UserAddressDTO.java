package com.rishi.tourist.dto;

import com.rishi.tourist.model.Address;
import com.rishi.tourist.model.User;

import lombok.Data;

@Data
public class UserAddressDTO {
	
	User user;
	Address address;

}
 