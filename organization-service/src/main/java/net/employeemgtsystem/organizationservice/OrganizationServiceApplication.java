package net.employeemgtsystem.organizationservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "org service rest api",
				description="org serv documentation",
				version="v1.0",
				contact =@Contact(
						name ="raghavendra",
						email="raghavendruppar@gmail.com",
						url="http://www"
				),
				license = @License(
						name="Apache 2.0",
						url="http"
				)

		),
		externalDocs = @ExternalDocumentation(
				description = "org serv doc",
				url="http"
		)
)
public class OrganizationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizationServiceApplication.class, args);
	}

}
