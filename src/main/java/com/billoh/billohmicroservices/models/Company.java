package com.billoh.billohmicroservices.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Company {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="company_id")
	private Long companyId;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="company_email")
	private String companyEmail;
	
	@Column(name="company_password")
	private String password;
	
	@Column(name="company_contact")
	private String companyContact;

}
