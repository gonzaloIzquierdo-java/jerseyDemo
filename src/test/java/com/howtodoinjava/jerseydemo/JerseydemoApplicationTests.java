package com.howtodoinjava.jerseydemo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import com.howtodoinjava.jerseydemo.curtomer.dao.CustomerDAO;
import com.howtodoinjava.jerseydemo.curtomer.dao.impl.CustomerDAOImpl;
import com.howtodoinjava.jerseydemo.curtomer.dto.Contract;
import com.howtodoinjava.jerseydemo.curtomer.dto.Customer;
import com.howtodoinjava.jerseydemo.greeting.GreetingResource;
import com.howtodoinjava.jerseydemo.greeting.dto.Greeting;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JerseydemoApplicationTests {

	
	//GreetingResource greeting= new GreetingResource();
	CustomerDAO customers= new CustomerDAOImpl();
	
	
	/*
	@Test
	public void allGreeting() {
		System.out.println("text AllGreeting");
		//greetingResource.getAllGreeting();
		Assert.assertEquals(200, greeting.getAllGreeting().getStatus());
		
	}
	
	
	@Test
	public void createGreeting201() {
		System.out.println("text createGreeting");
		Greeting inGreeting= new Greeting("Test1","Concepto test");
		Assert.assertEquals(201, greeting.createGreeting(inGreeting).getStatus());
		
		
		
	}	
	
	
	@Test
	public void createGreeting400() {
		System.out.println("text createGreeting");
		Greeting inGreeting= new Greeting(null,"Concepto test");
		Assert.assertEquals(400, greeting.createGreeting(inGreeting).getStatus());
		
	}
	
	@Test
	public void getGreeting200() {
		System.out.println("text getGreeting");		
		Assert.assertEquals(200, greeting.getGreeting("pepe").getStatus());
		
	}
	
	@Test
	public void getGreeting204() {
		System.out.println("text getGreeting");		
		Assert.assertEquals(204, greeting.getGreeting("valde").getStatus());
		
	}
	*/
	@Test
	public void getAllCustomersOK() {
		System.out.println("text getAllCustomers");
		//Assert.assertEquals(200,customers.getAllCustomers().getStatus());		
		Assert.assertTrue(customers.getAllCustomers().size()>0);
		
	}
	
	@Test
	public void getCustomerOK() {
		System.out.println("text getCustomer");		
		//Assert.assertEquals(200,customers.getCustomer("66666666R").getStatus());
		Assert.assertTrue(customers.getCustomer("66666666R")!=null);
	}
	
	@Test
	public void getCustomerKO() {
		System.out.println("text getCustomer");
		//Assert.assertEquals(204,customers.getCustomer("100").getStatus());
		Assert.assertFalse(customers.getCustomer("100")!=null);
	}
	
	@Test
	public void createCustomerOK() {
		List<Contract> listContract1=new ArrayList<Contract>();
		Contract contract1= new Contract("ContratoTest1");
		listContract1.add(contract1);		
		Customer customer=new Customer("66666666R-Test","DIOS-Test","Rayo Vallekano-Test",listContract1);		
		Assert.assertTrue(customers.createCustomer(customer));		
	}

	
	@Test
	public void createCustomerKO() {
		List<Contract> listContract1=new ArrayList<Contract>();
		Contract contract1= new Contract("ContratoTest1");
		listContract1.add(contract1);		
		Customer customer=new Customer(null,"DIOS-Test","Rayo Vallekano-Test",listContract1);		
		Assert.assertFalse(customers.createCustomer(customer));
	}

	
}
