package com.billoh.billohmicroservices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.billoh.billohmicroservices.models.Company;
import com.billoh.billohmicroservices.repositories.CompanyRepository;

public class CompanyServiceImpl implements CompanyService{
	
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public boolean createCompany(Company company) {
		
		String hashedPassword = passwordEncoder.encode(company.getPassword());
		company.setPassword(hashedPassword);
		companyRepository.save(company);
		
		return true;
	}

	

}
