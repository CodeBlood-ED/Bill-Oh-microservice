package com.billoh.billohmicroservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(value = "http://localhost:4200")
public class BillOhMicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillOhMicroservicesApplication.class, args);
	}

}
