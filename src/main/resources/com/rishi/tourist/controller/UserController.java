package com.rishi.tourist.controller;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rishi.tourist.dao.UserRepository;
import com.rishi.tourist.dto.CountDto;
import com.rishi.tourist.dto.UserAddressDTO;
import com.rishi.tourist.model.Address;
import com.rishi.tourist.model.User;
import com.rishi.tourist.service.UserService;
import com.rishi.tourist.util.StatusEnum;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/user")
public class UserController {

	//
	@Autowired
	UserService userService;
	//
	@Autowired
	UserRepository userRepository;
	//
	@Autowired
	MessageSource messageSource;
	
//	@PostMapping
//	public ResponseEntity<?> createUser(@Valid @RequestBody User user ) {
//
//		User user1 = userService.saveUser(user);
//		return new ResponseEntity<>(user1, HttpStatus.OK);
//	}
	@PostMapping
	public ResponseEntity<?> deleteRow(@Valid @RequestBody User user,
    		@RequestHeader(required = false,value = "Accept-Language") Locale locale) {
		User user1 = userService.saveUser(user);
		String s = messageSource.getMessage("user.save",null,locale);
		return new ResponseEntity (s,HttpStatus.FOUND);
	}
	@PostMapping(path = "/address")
	public ResponseEntity<?> createAddress(@RequestBody Address address) {
		Address address1 = userService.saveAddress(address);
		return new ResponseEntity<>(address1, HttpStatus.OK);

	}
	
	@GetMapping("/inactiveById")
	public List<User> getUsersByIdAndStatus(@RequestParam long id, @RequestParam StatusEnum status) {
	    return userService.getUsersByIdAndStatus(id, status);
	}
		@GetMapping(path = "/{id}")

	public ResponseEntity<?> getUser(@PathVariable long id) {
		User u = userService.findUser(id);
		return new ResponseEntity<>(u, HttpStatus.OK);
	}
 
	@GetMapping(path = "/address/{id}")

	public ResponseEntity<?> getAddress(@PathVariable long id) {
		Address a = userService.findAddress(id);
		return new ResponseEntity<>(a, HttpStatus.OK);
	}
	
	@GetMapping(path = "/first-name")
	public ResponseEntity<?> findByFirstName(@RequestParam(name = "firstName") String firstName) {

		List<User> users = userService.findByFirstName(firstName);
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	//
	@GetMapping(path = "/name")
	public ResponseEntity<?> findByFirstNameOrLast(@RequestParam(name = "firstName") String firstName) {

		List<User> users = userService.findByFirstOrLastName(firstName);
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<?> updateUser(@RequestBody User user) {
		try {
			User user2 = userService.updateUser(user);
			return new ResponseEntity<>(user2, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
		@GetMapping(path = "/search/{name}")
	public ResponseEntity<?> searchFirstName(@PathVariable String name) {

		return new ResponseEntity<>(userService.findByNameSearch(name), HttpStatus.OK);
	}

	@GetMapping(path = "/all")
	public ResponseEntity<?> getAllUsers() {
		return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
	}

	@GetMapping(path = "/inactive")      
	public ResponseEntity<?> getActiveUsers() {     
		return new ResponseEntity<>(userService.getActiveUsers(StatusEnum.INACTIVE), HttpStatus.OK);
	}
	
	@RequestMapping("/user/count")
	public CountDto getNumberOfUsers(){
	    Long activeCount= userService.countByStatus(StatusEnum.ACTIVE);
	    Long inactiveCount=userService.countByStatus(StatusEnum.INACTIVE);
	    CountDto dto=new CountDto();
	    dto.setActiveCount(activeCount);
	    dto.setInactiveCount(inactiveCount);
	    return dto;	    
	}	
	@GetMapping(path = "/all/{page}/{rows}")
	public ResponseEntity<?> getAllUsers(@PathVariable int page, @PathVariable int rows) {
		return new ResponseEntity<>(userService.getAllUsers(page, rows), HttpStatus.OK);
	}

	@GetMapping(path = "/all/sort/name/{page}/{rows}")
	public ResponseEntity<?> getAllUsersBySort(@PathVariable int page, @PathVariable int rows) {
		return new ResponseEntity<>(userService.getAllUsersByLastNameSort(page, rows), HttpStatus.OK);
	}

	@GetMapping(path = "/update/user-and-address")
	public ResponseEntity<?> updateUserAndAddress(@RequestBody UserAddressDTO userAddressDTO) {
		try {
			return new ResponseEntity<>(userService.updateUserAndAddress(userAddressDTO), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(path = "/multiple/address/{id}")
	public ResponseEntity<?> findMultipleAddressById(@PathVariable long id) {
		try {
			return new ResponseEntity<>(userService.findMultipleAddressById(id), HttpStatus.OK);
		} catch (Exception e) {

			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
//	 @DeleteMapping("/{id}")
//	    public ResponseEntity<?> deleteRow(@PathVariable Long id,
//	    		@RequestHeader(required = false,value = "Accept-Language") Locale locale) {
//	        Optional<User> dataTableRow = userRepository.findById(id);
//	        if (dataTableRow.isPresent()) {
//	        	userRepository.deleteById(id);
//	        	System.out.println("deleted");
//	            return ResponseEntity.ok().build();
//	        } else {
//	        	String s = messageSource.getMessage("delete.error", null,locale);
//	        	
//	        	System.out.println(String.format(s, id));
//	            return new ResponseEntity (String.format(s, id),HttpStatus.NOT_FOUND);
//	        }
//	    }
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteRow(@PathVariable Long id) {    		
        Optional<User> dataTableRow = userRepository.findById(id);
        if (dataTableRow.isPresent()) {
        	userRepository.deleteById(id);
        	System.out.println("deleted");
            return ResponseEntity.ok().build();
        } else {
            return  ResponseEntity.notFound().build();
        }
    }
	@PostMapping(path="/updateUserByPath")
	public ResponseEntity<?> updateUserByPath( @RequestParam (name = "filePath")  String filePath,@RequestParam(name = "id") long id){
		Optional<User> u1= userRepository.findById(id);
		User u = u1.get();
		u.setFilePath(filePath);
		return new ResponseEntity<>(userRepository.save(u), HttpStatus.OK);
	}
	@GetMapping(path="/getFilePathById")
	public ResponseEntity<?> getDownloadById (@RequestParam(name = "id") long id){
		Optional<User> u1= userRepository.findById(id);
		User u = u1.get();
		String filePath =u.getFilePath();
		return new ResponseEntity<>(filePath, HttpStatus.OK);
	}



}