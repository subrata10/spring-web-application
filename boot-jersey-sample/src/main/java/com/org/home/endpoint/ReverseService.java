package com.org.home.endpoint;

import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Service
@Path("/reverse")
public class ReverseService {

    @GET
    @Produces("application/json")
    public String reverse(@QueryParam("data") @NotNull String data) {
        return new StringBuilder(data).reverse().toString();
    }
}
