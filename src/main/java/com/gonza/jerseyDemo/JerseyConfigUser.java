package com.gonza.jerseyDemo;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.gonza.jerseyDemo.user.controller.UserResource;


@Component
public class JerseyConfigUser extends ResourceConfig{
	
	 public void JerseyConfig() 
	    {
	        register(UserResource.class);
	    }
}
