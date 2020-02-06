package com.howtodoinjava.jerseydemo.greeting;

import java.net.URI;
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

import com.howtodoinjava.jerseydemo.greeting.dto.Greeting;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "greeting")
@Path("/greeting")
public class GreetingResource {

	
	 @GET
	 @Produces(MediaType.APPLICATION_JSON)
	 public Response getAllGreeting() {
		 System.out.println("Entrada getAllGreeting");
		 List<Greeting> listGreeting= new ArrayList<Greeting>();
		 
		 Greeting ejemplo1= new Greeting("1","Gonza");
		 listGreeting.add(ejemplo1);
		 Greeting ejemplo2= new Greeting("2","Valde");
		 listGreeting.add(ejemplo2);
		 Greeting ejemplo3= new Greeting("3","David");
		 listGreeting.add(ejemplo3);
		 
		 return Response
	                .status(200)
	                .entity(listGreeting)
	                .build();
		 
	 }
	 
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createGreeting(Greeting inGreeting) {
		System.out.println("Entradada createGreeting con parametro:"+inGreeting);
		System.out.println("Entradada createGreeting con parametro:"+inGreeting.getId());
		System.out.println("Entradada createGreeting con parametro:"+inGreeting.getContent());
		
		
		if(inGreeting!=null){
			if(inGreeting.getId()!=null) {
				Greeting outGreeting=new Greeting(inGreeting.getId(), inGreeting.getContent());
				return Response.status(201).entity(outGreeting).build();
				//lo correcto seria para no devolver el objeto, el front debería invocar a la pantalla de listado y
				//a partir de ella al detalle del objeto creado
				//return Response.status(201).entity(null).build();
			}
		}
		return Response.status(400).entity(null).build();
		//si no queremos informar que el cuerpo del mesage es incorrecto
		//return Response.status(406).entity(null).build();
		/* URL CON LOS POSIBLES CODIGOS DE STATUS DEVUELTOS
		 * https://httpstatuses.com/
		 */
		
	}
	 
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Response getGreeting(@PathParam("id") String id) {
		System.out.println("Entrada getGreeting");
		Greeting outGreeting=new Greeting(id, "Bienvenido "+id);
		
		if("valde".equals(id)) {
			return Response.status(204).entity(null).build();
		}
		
		return Response.status(200).entity(outGreeting).build();
		
	}
	
}
