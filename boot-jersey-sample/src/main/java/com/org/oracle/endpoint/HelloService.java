package com.org.oracle.endpoint;

import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Service
@Path("/hello")
public class HelloService {

    @GET
    @Produces("application/json")
    public String hello() {
        return "Hello from Spring boot";
    }
}
