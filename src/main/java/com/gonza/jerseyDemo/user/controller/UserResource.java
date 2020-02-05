package com.gonza.jerseyDemo.user.controller;


import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.gonza.jerseyDemo.user.dto.User;
import com.gonza.jerseyDemo.user.dto.Users;
 

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "users")
@Path("/users")
public class UserResource {

	
	 @GET
	 @Produces("application/json")
	 public Response getAllUsers() {
		 
		 List<User>listUser=new ArrayList<User>();
		 User userPrueba1= new User(1,"Uri1","Gonza","Lito");
		 listUser.add(userPrueba1);
		 User userPrueba2= new User(2,"Uri2","David","Pelokis");
		 listUser.add(userPrueba2);
		 User userPrueba3= new User(3,"Uri3","Angel","Valde");
		 listUser.add(userPrueba3);
		 
		 
		 return Response.status(200).entity(listUser).build();
		 
	 }
	
}
