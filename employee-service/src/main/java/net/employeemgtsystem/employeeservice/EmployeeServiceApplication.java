package net.employeemgtsystem.employeeservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
@OpenAPIDefinition(
		info = @Info(
				title = "emp service rest api",
				description="emp serv documentation",
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
				description = "emp serv doc",
				url="http"
		)
)

@SpringBootApplication
@EnableFeignClients
public class EmployeeServiceApplication {
	//@Bean
//	public RestTemplate restTemplate(){
//		return new RestTemplate();
//	}

	@Bean

	public WebClient webClient(){
		return WebClient.builder().build();
	}


	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
