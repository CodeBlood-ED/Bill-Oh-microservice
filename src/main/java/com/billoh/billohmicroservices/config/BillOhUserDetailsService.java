package com.billoh.billohmicroservices.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.billoh.billohmicroservices.models.Customer;
import com.billoh.billohmicroservices.repositories.CustomerRepository;

@Service
public class BillOhUserDetailsService implements UserDetailsService{
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Customer customer = customerRepository.findByCustomerEmail(username).orElseThrow(() -> 
								new UsernameNotFoundException("User details not found for the user: "+username));
		List<GrantedAuthority> grantedAuthority = List.of(new SimpleGrantedAuthority(customer.getCustomerRole()));
		
		return new User(customer.getCustomerEmail(), customer.getCustomerPwd(), grantedAuthority);
		
	}

}
