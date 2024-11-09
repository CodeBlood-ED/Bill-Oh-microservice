package com.billoh.billohmicroservices.services;

import org.springframework.stereotype.Service;

import com.billoh.billohmicroservices.models.Company;

@Service
public interface CompanyService {

	boolean createCompany(Company company);
}
