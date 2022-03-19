package com.multiple.datasource.primary.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.multiple.datasource.primary.entity.Customer;
import com.multiple.datasource.primary.service.CustomerService;

@RestController
//@Controller
public class CustomerController {
	
	private static final Logger log =LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private CustomerService customerService;
	
	
	@RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
	public String saveCustomerController(@RequestBody Customer customerData) {
		
		//System.out.println("Printing customer data:"+customerData);
		
		customerService.saveCustomerData(customerData);	
		
		log.info("Printing customer name:"+customerData.getCustomer_name());
		log.info("Printing customer state:"+customerData.getCustomer_state());
		log.info("Printing customer age:"+customerData.getCustomer_age());
		
		return "ok";
		
	}
	
	
	

}
