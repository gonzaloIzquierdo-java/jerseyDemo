package com.howtodoinjava.jerseydemo.curtomer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.factory.annotation.Autowired;

import com.howtodoinjava.jerseydemo.curtomer.dao.CustomerDAO;
import com.howtodoinjava.jerseydemo.curtomer.dto.Customer;




@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "customers")
@Path("/customers")
public class CustomerResource {
	
	
	
	@Autowired
	private CustomerDAO customerDAO;
	
	 @GET
	 @Produces(MediaType.APPLICATION_JSON)
	 public Response getAllCustomers() {
		 System.out.println("Entrada getAllCustomers");	
		 System.out.println("Entrada getAllCustomers customerDAO="+customerDAO);	
		 
		 return Response
	                .status(200)
	                .entity(customerDAO.getAllCustomers())
	                .build();
		 		 
	 }
	 
	 
	 @GET
	 @Path("/{id}")
	 @Produces("application/json")
	 public Response getCustomer(@PathParam("id") String id) {
		 System.out.println("Entrada getCustomer con parametro:"+id);
		 System.out.println("Entrada getCustomer  customerDAO.getAllCustomers():"+ customerDAO.getAllCustomers().size());
		
		
		 Customer out=customerDAO.getCustomer(id);
		 
		 if(out!=null) {
			 return Response.status(200).entity(out).build();
		 }
		 
		 return Response.status(204).entity(out).build();
		 
		 
	 }
	 
	 
	 @POST
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_JSON)
	 public Response createCustomer(Customer incustomer) {
		 
		 System.out.println("Entrada createCustomer");
		 if(customerDAO.createCustomer(incustomer)) {
			 return Response.status(201).entity(incustomer).build(); 			
		 }
		 return Response.status(400).entity(null).build();
		 
	 }
	 
	

}
