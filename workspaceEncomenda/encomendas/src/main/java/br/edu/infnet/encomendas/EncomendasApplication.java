package br.edu.infnet.encomendas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title = "Swagger Encomenda", description = "Swagger do MicroServiço de Encomendas", version="1.0"))
@EnableFeignClients
@SpringBootApplication
public class EncomendasApplication {

	public static void main(String[] args) {
		SpringApplication.run(EncomendasApplication.class, args);
	}

}
