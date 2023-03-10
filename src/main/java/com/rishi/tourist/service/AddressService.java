
package com.rishi.tourist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rishi.tourist.dao.AddressRepository;
import com.rishi.tourist.dao.UserRepository;

@Service
public class AddressService {

	//

	@Autowired
	UserRepository userRepository; //

	@Autowired
	AddressRepository addressRepository;


	/*
	 * public Address saveAddress(Address address) { // TODO Auto-generated
	 * method return addressRepository.save(address); }
	 */

}
