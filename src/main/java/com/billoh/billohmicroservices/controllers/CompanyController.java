package com.billoh.billohmicroservices.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.billoh.billohmicroservices.models.Company;
import com.billoh.billohmicroservices.services.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {
	

	CompanyService companyService;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerCompany(@RequestBody Company company) {
		
		boolean isCompanyRegistered = companyService.createCompany(company);
		if(isCompanyRegistered) {
			return ResponseEntity.status(HttpStatus.CREATED).body("Company registration successful");
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create Company");
		}
	}

}
