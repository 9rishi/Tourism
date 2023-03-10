package com.rishi.tourist.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rishi.tourist.model.User;
import com.rishi.tourist.util.StatusEnum;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findByFirstName(String firstName);
	
	List<User> findByFirstNameOrLastNameOrderByFirstName(String firstName, String firstName2);

	List<User> findByFirstNameContains(String nameSearch);

    List<User> findByStatus(StatusEnum statusEnum);
    
    long countByStatus (StatusEnum statusEnum);
    
    List<User> deleteByStatus (StatusEnum statusEnum);

     List<User> findByIdAndStatus(Long id, StatusEnum status);
  

}



//List<User> findById(long id);
// List<User> updateUser(long id) ;
// void save(List<User> updateUser);
//
