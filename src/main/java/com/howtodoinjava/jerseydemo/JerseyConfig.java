package com.howtodoinjava.jerseydemo;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.howtodoinjava.jerseydemo.curtomer.CustomerResource;
import com.howtodoinjava.jerseydemo.greeting.GreetingResource;
 
@Component
public class JerseyConfig extends ResourceConfig 
{
    public JerseyConfig() 
    {
        register(UserResource.class);
        register(GreetingResource.class);
        register(CustomerResource.class);
    }
}
