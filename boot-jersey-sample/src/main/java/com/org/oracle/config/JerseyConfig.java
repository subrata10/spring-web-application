package com.org.oracle.config;

import com.org.oracle.endpoint.HelloService;
import com.org.oracle.endpoint.ReverseService;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(HelloService.class);
        register(ReverseService.class);
    }

}
