package com.howtodoinjava.jerseydemo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import com.howtodoinjava.jerseydemo.greeting.GreetingResource;
import com.howtodoinjava.jerseydemo.greeting.dto.Greeting;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JerseydemoApplicationTests {

	
	GreetingResource greeting= new GreetingResource();
	
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
	

}
