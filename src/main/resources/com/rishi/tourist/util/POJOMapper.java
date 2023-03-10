package com.rishi.tourist.util;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.rishi.tourist.dto.UserAddressDTO;
import com.rishi.tourist.model.Address;
import com.rishi.tourist.model.User;

@Mapper

public interface POJOMapper{

	POJOMapper INSTANCE = Mappers.getMapper(POJOMapper.class);

	User userToUser(User user);
	Address addressToAddress(Address address); 
	User userAddressDTOToUser(UserAddressDTO userAddressDTO);
	Address userAddressDTOToAddress(UserAddressDTO userAddressDTO);
}
