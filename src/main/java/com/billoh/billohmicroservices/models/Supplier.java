package com.billoh.billohmicroservices.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="supplier")
public class Supplier {

	@Id
	@Column(name="supplier_gst")
	private String supplierGST;
	@Column(name="supplier_name")
	private String supplierName;
	@Column(name="supplier_address")
	private String supplierAddress;
	@Column(name="supplier_contact")
	private String supplierContact;
	
	public String getSupplierGST() {
		return supplierGST;
	}
	public void setSupplierGST(String supplierGST) {
		this.supplierGST = supplierGST;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSupplierAddress() {
		return supplierAddress;
	}
	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}
	public String getSupplierContact() {
		return supplierContact;
	}
	public void setSupplierContact(String supplierContact) {
		this.supplierContact = supplierContact;
	}

}
