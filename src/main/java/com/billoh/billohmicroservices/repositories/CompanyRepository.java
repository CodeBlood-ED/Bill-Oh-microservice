package com.billoh.billohmicroservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.billoh.billohmicroservices.models.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

	

}
