package com.ravi.DatabaseAPI;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDTO extends JpaRepository<CustomerEntity, Integer> {

	
	@Query(value = "select * from customer_Data where company_Name = ?", nativeQuery = true)
	List<CustomerEntity> findByName(String name);

}
