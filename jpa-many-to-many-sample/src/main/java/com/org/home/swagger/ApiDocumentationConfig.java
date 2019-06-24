package com.org.oracle.swagger;


import io.swagger.annotations.Contact;
import io.swagger.annotations.ExternalDocs;
import io.swagger.annotations.Info;
import io.swagger.annotations.License;
import io.swagger.annotations.SwaggerDefinition;

@SwaggerDefinition(
        info = @Info(
                description = "JPA Resources",
                version = "V12.0.12",
                title = "Sample jpa many to many example",
                contact = @Contact(
                        name="subrata sikdar",
                        email = "subrata.sikdar@mysite.com",
                        url = "https://www.myhome.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "http://www.apache.org/licenses/LICENSE-2.0"
                )
        ),
        consumes = {"application/json", "application/xml"},
        produces = {"application/json", "application/xml"},
        schemes = {SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS},
        externalDocs = @ExternalDocs(value = "Read this for sure", url = "https://www.myhome.com")

)
public interface ApiDocumentationConfig {

}
