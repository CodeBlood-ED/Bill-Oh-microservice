package com.billoh.billohmicroservices.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.billoh.billohmicroservices.models.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	
	Optional<Customer> findByCustomerEmail(String customerEmail);

}
