package com.howtodoinjava.jerseydemo.curtomer.dao;


import java.util.List;


import com.howtodoinjava.jerseydemo.curtomer.dto.Customer;

public interface CustomerDAO {
	
	public List<Customer> getAllCustomers();
	public Customer getCustomer(String id);
	public boolean createCustomer(Customer customer);
	
}
