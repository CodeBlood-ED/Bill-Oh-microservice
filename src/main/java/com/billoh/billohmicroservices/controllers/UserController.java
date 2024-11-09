package com.billoh.billohmicroservices.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.billoh.billohmicroservices.config.BillOhUserDetailsService;
import com.billoh.billohmicroservices.models.Customer;
import com.billoh.billohmicroservices.repositories.CustomerRepository;


@RestController
public class UserController {

	private CustomerRepository customerRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	BillOhUserDetailsService userDetailsService;

	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody Customer customer) {
		try {
			String hashPwd = passwordEncoder.encode(customer.getCustomerPwd());
			customer.setCustomerPwd(hashPwd);
			Customer savedCustomer = customerRepository.save(customer);
			if (savedCustomer.getCustomerId() > 0) {
				return ResponseEntity.status(HttpStatus.CREATED).body("Given user details saved successfully");
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User registration failed");
			}
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("An exception occured" + ex.getMessage());
		}
	}
	@GetMapping("/login")
	public ResponseEntity<String> customerLogin () {
		return ResponseEntity.status(HttpStatus.OK).body("Success logging in with : ");
	}

}
