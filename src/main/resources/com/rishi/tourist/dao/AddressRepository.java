package com.rishi.tourist.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rishi.tourist.model.Address;
import com.rishi.tourist.model.User;
@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

	

	List<Address> findByUser(User user);

	//
	@Query("from Address a where a.user.id=?1")
	List<Address> findMultipleAddresses(long id); 

	
	
	
}
/*
 * @Test public void
 * whenDeleteByIdFromRepository_thenDeletingShouldBeSuccessful() {
 * repository.deleteById(book1.getId());
 * assertThat(repository.count()).isEqualTo(1); }
 */