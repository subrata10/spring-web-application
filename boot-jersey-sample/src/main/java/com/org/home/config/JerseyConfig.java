package com.org.home.config;

import com.org.home.endpoint.HelloService;
import com.org.home.endpoint.ReverseService;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(HelloService.class);
        register(ReverseService.class);
    }

}
