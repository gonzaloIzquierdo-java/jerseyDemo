package com.howtodoinjava.jerseydemo.curtomer.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.howtodoinjava.jerseydemo.curtomer.dao.CustomerDAO;
import com.howtodoinjava.jerseydemo.curtomer.dto.Contract;
import com.howtodoinjava.jerseydemo.curtomer.dto.Customer;

@Component
public class CustomerDAOImpl implements CustomerDAO{

	
	private List<Customer> listCustomer= initListCustomer();
	
	
	public List<Customer> getAllCustomers(){		
		
		return listCustomer;
		
	}
	
	
	public Customer getCustomer(String id) {
		//1 funcion lambda	
		/*
		 List<Customer> listCustomerOut=getAllCustomers().stream()
		 			.filter(c -> id.equals(c.getDni()))
		 			.collect(Collectors.toCollection(() -> new ArrayList<Customer>()));
		 
		
		 if(listCustomerOut.size()>0) {
			 System.out.println("ENCONTRADO");
			 return listCustomerOut.get(0);
		 }else {
			 System.out.println("NO ENCONTRADO");
		 }
		 */
		//2 funcion lambda
		 return evaluaCurstomer(id,c ->id.equals(c.getDni()));
		
		
	}
	
	
	public boolean createCustomer(Customer customer) {
		if(customer!=null) {
			 if(customer.getDni()!=null&&!customer.getContracts().isEmpty()) {
				 listCustomer.add(customer);
				 return true;
			 }
		}
		
		return false;
	}
	
	
	private Customer evaluaCurstomer(String dni,Predicate<Customer> predicado) {
		 for(Customer row:listCustomer) {
			 if(predicado.test(row)) {
				 return row;
			 }
			 
		 }
		 return null;
		 
	 }
	
	
	

	
	private List<Customer> initListCustomer() {
		List<Customer> init= new ArrayList<Customer>();
		init.add(getCustomer1());
		init.add(getCustomer2());
		return init;	
	}
	
	private Customer getCustomer1() {
		 
		 List<Contract> listContract1=new ArrayList<Contract>();
		 listContract1.add(getContract("Contrato1"));
		 listContract1.add(getContract("Contrato2"));
		 
		 return new Customer("50607896Y","Pepe Lopez","ACS",listContract1);
		 
		 
	 }
	 
	 private Customer getCustomer2() {
		 
		 List<Contract> listContract1=new ArrayList<Contract>();
		 listContract1.add(getContract("Contrato1"));
		 listContract1.add(getContract("Contrato2"));
		 listContract1.add(getContract("Contrato3"));
		 listContract1.add(getContract("Contrato4"));
		 
		 return new Customer("66666666R","DIOS","Rayo Vallekano",listContract1);
		 
		 
	 }
	 
	 
	 private Contract getContract(String numberContract) {
		 
		 return new Contract(numberContract);
		 
	 }




	
}
