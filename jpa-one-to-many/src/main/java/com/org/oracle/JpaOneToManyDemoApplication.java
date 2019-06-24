package com.org.oracle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Source of this sample <link>https://www.callicoder.com/hibernate-spring-boot-jpa-one-to-many-mapping-example/</link>
 */

@SpringBootApplication
@EnableJpaAuditing
public class JpaOneToManyDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(JpaOneToManyDemoApplication.class, args);
    }
}
