package com.multiple.datasource.primary.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiple.datasource.primary.entity.Customer;
import com.multiple.datasource.primary.repository.CustomerRepository;

@Service
public class CustomerService {
	
	private static final Logger log = LoggerFactory.getLogger(CustomerService.class);

	@Autowired
	private CustomerRepository customerRepository;

	public void saveCustomerData(Customer customer) {

		customerRepository.save(customer);
		
		log.info("Customer data saved successfully");

	}

}
