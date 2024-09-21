package br.edu.infnet.fabricante;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Swagger Fabricante", description = "Swagger do MicroServiço de Fabricante", version="1.0"))
public class FabricanteApplication {

	public static void main(String[] args) {
		SpringApplication.run(FabricanteApplication.class, args);
	}

}
