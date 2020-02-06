package com.howtodoinjava.jerseydemo.curtomer;

import java.util.ArrayList;
import java.util.List;

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

import com.howtodoinjava.jerseydemo.curtomer.dto.Contract;
import com.howtodoinjava.jerseydemo.curtomer.dto.Customer;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "customers")
@Path("/customers")
public class CustomerResource {
	
	
	
	 @GET
	 @Produces(MediaType.APPLICATION_JSON)
	 public Response getAllCustomers() {
		 System.out.println("Entrada getAllCustomers");
		 		 
		 List<Customer> listCustomer= new ArrayList<Customer>();
		 listCustomer.add(getCustomer1());
		 listCustomer.add(getCustomer2());
		 
		 return Response
	                .status(200)
	                .entity(listCustomer)
	                .build();
		 
		 
	 }
	 
	 @GET
	 @Path("/{id}")
	 @Produces("application/json")
	 public Response getCustomer(@PathParam("id") String id) {
		 System.out.println("Entrada getCustomer");
		 Customer out=null;
		 if("1".equals(id)) {
			 out=getCustomer1();
		 }else if("2".equals(id)) {
			 out=getCustomer2();
		 }
		 
		//luego hacer con funciones lambda
		 
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
		 if(incustomer!=null) {
			 if(incustomer.getDni()!=null&&!incustomer.getContracts().isEmpty()) {
				 return Response.status(201).entity(incustomer).build(); 
			 }
		 }
		 return Response.status(400).entity(null).build();
		 
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
