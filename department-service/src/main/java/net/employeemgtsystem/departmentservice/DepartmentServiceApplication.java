package net.employeemgtsystem.departmentservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Dep service rest api",
				description="dep serv documentation",
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
				description = "dep serv doc",
				url="http"
		)
)
public class DepartmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}

}
