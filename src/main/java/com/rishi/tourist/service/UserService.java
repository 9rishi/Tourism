package com.rishi.tourist.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.rishi.tourist.dao.AddressRepository;
import com.rishi.tourist.dao.BookingRepository;
import com.rishi.tourist.dao.UserRepository;
import com.rishi.tourist.dto.UserAddressDTO;
import com.rishi.tourist.model.Address;
import com.rishi.tourist.model.Booking;
import com.rishi.tourist.model.User;
import com.rishi.tourist.util.POJOMapper;
import com.rishi.tourist.util.StatusEnum;

@Service
public class UserService {

	//	
	@Autowired
	UserRepository userRepository;
	//
	@Autowired
	AddressRepository addressRepository;
	@Autowired
	BookingRepository bookingRepository;
//	

	public User saveUser(User user) {

		//user.setStatus(StatusEnum.ACTIVE);
		return userRepository.save(user);

	}

	public Address saveAddress(Address address) {
		Address addres = new Address();
		Optional<User> user = userRepository.findById(address.getUser().getId());
		if (user.isPresent()) {
			addres.setUser(user.get());
		}
		addres = addressRepository.save(address);
		return addres;
	}
//	public List<User> getActiveUsers(StatusEnum statusEnum) {
//		List<User> u5 = userRepository.findByStatus(statusEnum);
//		return u5;
//	} 
	
	public List<User> getUsersByIdAndStatus(Long id, StatusEnum status) {
	    return userRepository.findByIdAndStatus(id, status);
	}

	
	public Address findAddress(long id) {
		// TODO Auto-generated method stub
		return addressRepository.findById(id).get();
	}

	public List<User> findByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return userRepository.findByFirstName(firstName);
	}

	public List<User> findByFirstOrLastName(String firstName) {
		// TODO Auto-generated method stub
		return userRepository.findByFirstNameOrLastNameOrderByFirstName(firstName, firstName);
	}

	public User updateUser(User user) throws Exception {
		Optional<User> user3 = userRepository.findById(user.getId());
		if (user3.isPresent()) {
			User pUser = user3.get();
			pUser = POJOMapper.INSTANCE.userToUser(user);
			return userRepository.save(pUser);
		} else {
		throw new Exception("user doesn't exist with id:" + user.getId());
		}
	} 

	public Address updateAddress(Address address) throws Exception {
		Optional<Address> adOptional = addressRepository.findById(address.getId());
		if (adOptional.isPresent()) {
		Address pAddress = adOptional.get();
			pAddress = POJOMapper.INSTANCE.addressToAddress(address);
		return addressRepository.save(pAddress);
		} else {
			throw new Exception("user doesn't exist with id:" + address.getId());
		}
}

	@Transactional
	public UserAddressDTO updateUserAndAddress(UserAddressDTO userAddressDTO) throws Exception {

		if (!userRepository.existsById(userAddressDTO.getUser().getId()))
			throw new Exception("user doesn't exist with id:" + userAddressDTO.getUser().getId());
		if (!addressRepository.existsById(userAddressDTO.getAddress().getId()))
			throw new Exception("Address doesn't exist with id:" + userAddressDTO.getAddress().getId());

		User user = updateUser(userAddressDTO.getUser());
		Address address = addressRepository.findById(userAddressDTO.getAddress().getId()).get();

		address = POJOMapper.INSTANCE.addressToAddress(userAddressDTO.getAddress());
		address.setUser(user);

	address = addressRepository.save(address);
		userAddressDTO.setUser(user);
		userAddressDTO.setAddress(address);

		return userAddressDTO;

	}

	public List<Address> findMultipleAddressById(long id) throws Exception {
		User user = userRepository.findById(id).get();
		if (user != null)
			return addressRepository.findByUser(user);
		else {
			throw new Exception("user doesn't exist with id:" + id);
		}
	}

	public List<User> findByNameSearch(String nameSearch) {
		return userRepository.findByFirstNameContains(nameSearch);
	}

	public List<Address> findMultipleAddressesById(long id) throws Exception {
		User user = userRepository.findById(id).get();
		if (user != null)
			return addressRepository.findMultipleAddresses(id);
		else {
			throw new Exception("user doesn't exist with id:" + id);
		}
	}
	//

	public Booking saveBooking(Booking booking) {

		Booking book = new Booking();
		Optional<User> user = userRepository.findById(booking.getUser().getId());
		if (user.isPresent()) {
			book.setUser(user.get());
			;
		}
		return bookingRepository.save(booking);
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public List<User> getActiveUsers(StatusEnum statusEnum) {
		List<User> u5 = userRepository.findByStatus(statusEnum);
		return u5;
	} 
	public long countByStatus(StatusEnum statusEnum) {
	    return userRepository.countByStatus(statusEnum);
	}

	public Page<User> getAllUsers(int page, int rows) {

		PageRequest pageRequest = PageRequest.of(page, rows);
		return userRepository.findAll(pageRequest);
	}

	public Page<User> getAllUsersByLastNameSort(int page, int rows) {
		
		Sort sort = Sort.by(Collections.singletonList(Order.desc("lastName")));
		PageRequest pageRequest = PageRequest.of(page, rows, sort);

		return userRepository.findAll(pageRequest);
	}

	public User findUser(long id) {
		return userRepository.findById(id).get();
	}

	public List<User> deleteStudent(StatusEnum statusEnum) {
		return userRepository.deleteByStatus(statusEnum);
		
	}


}
