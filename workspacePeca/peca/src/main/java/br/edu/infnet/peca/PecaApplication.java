package br.edu.infnet.peca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@EnableFeignClients
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Swagger Peça", description = "Swagger do MicroServiço de Peça", version="1.0"))
public class PecaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PecaApplication.class, args);
	}

}
