package com.multiple.datasource.secondary.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiple.datasource.secondary.entity.Employee;
import com.multiple.datasource.secondary.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);

	@Autowired
	private EmployeeRepository employeeRepository;

	public void saveEmployeeData(Employee employee) {

		employeeRepository.save(employee);
		
		log.info("Employee data saved successfully");

	}

}
