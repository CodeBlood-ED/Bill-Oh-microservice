package com.billoh.billohmicroservices.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.billoh.billohmicroservices.models.Supplier;
import com.billoh.billohmicroservices.repositories.SupplierRepository;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
	
	@Autowired
	private SupplierRepository supplierRepository;
	
	@PostMapping("/registersupplier")
	public ResponseEntity<String> registerSupplier(@RequestParam String supplierName, 
			@RequestParam String supplierAddress, @RequestParam String supplierContact, @RequestParam String supplierGST) 
	{
		Supplier supplierDetails = new Supplier();
		supplierDetails.setSupplierGST(supplierGST);
		supplierDetails.setSupplierName(supplierName);
		supplierDetails.setSupplierAddress(supplierAddress);
		supplierDetails.setSupplierContact(supplierContact);
		supplierRepository.save(supplierDetails);
		
		return ResponseEntity.status(HttpStatus.OK).body("Supplier registration complete");
	}
	
	@GetMapping("/retrivesuppliersfromdatabase")
	public ResponseEntity<List<Supplier>> retrieveSuppliersFromDB() {
		List<Supplier> suppliers = new ArrayList<>();
		suppliers = supplierRepository.findAll();
		for(int i=0;i<suppliers.size();i++) {
			if(suppliers.contains(suppliers.get(i)) && suppliers.get(i).getSupplierGST().isEmpty()) {
				suppliers.remove(i);
			}
		}
		return ResponseEntity.status(HttpStatus.OK).body(suppliers);
	} 

}
