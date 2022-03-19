package com.multiple.datasource.secondary.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.multiple.datasource.secondary.entity.Employee;
import com.multiple.datasource.secondary.service.EmployeeService;

@RestController
//@Controller
public class EmployeeController {
	
	private static final Logger log =LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public String saveCustomerController(@RequestBody Employee employeeData) {
		
		//System.out.println("Printing customer data:"+customerData);
		
		employeeService.saveEmployeeData(employeeData);	
		
		log.info("Printing customer name:"+employeeData.getEmployee_name());
		log.info("Printing customer state:"+employeeData.getEmployee_city());
		log.info("Printing customer age:"+employeeData.getEmployee_age());
		
		return "ok";
		
	}
	
	
	

}
