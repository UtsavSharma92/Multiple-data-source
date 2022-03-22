package com.multiple.datasource.primary.service;

import java.lang.reflect.Method;

import javax.persistence.EntityManager;
//import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.multiple.datasource.primary.entity.Customer;
import com.multiple.datasource.primary.repository.CustomerRepository;

@Service
public class CustomerService {

	private static final Logger log = LoggerFactory.getLogger(CustomerService.class);

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory;
	
	@Autowired
	private EntityManager entityManager;

//	@Transactional("primaryTransactionManager")
	public void saveCustomerData(Customer customer) {
		
		log.info("Entity Manager implementation class methods:"+entityManager.getClass().getDeclaredMethods());
		
		for(Method m : entityManager.getClass().getDeclaredMethods()) {
			
			System.out.println(m.getName());
			
		}	
		
	//	log.info("Persistence providor:" + primaryEntityManagerFactory.getPersistenceProvider());
		
		log.info("Persistence unit name:"+primaryEntityManagerFactory.getPersistenceUnitName());
		
		log.info("Persistence property map:"+primaryEntityManagerFactory.getJpaPropertyMap());
		
		log.info("Persistence entity manager:"+primaryEntityManagerFactory.getEntityManagerInterface());
		
		log.info("Persistence entity manager class:"+primaryEntityManagerFactory.getClass());
		

		customerRepository.save(customer);
		
		Customer c1 = new Customer();
		
		c1.setCustomer_name("Frank");
		c1.setCustomer_age(34);
		c1.setCustomer_state("Madhya Pradesh");
		
		customerRepository.save(c1);
		

		log.info("Customer data saved successfully");

	}

}
