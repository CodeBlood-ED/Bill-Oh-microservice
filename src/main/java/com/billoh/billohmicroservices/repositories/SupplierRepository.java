package com.billoh.billohmicroservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.billoh.billohmicroservices.models.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier,String>{

}
