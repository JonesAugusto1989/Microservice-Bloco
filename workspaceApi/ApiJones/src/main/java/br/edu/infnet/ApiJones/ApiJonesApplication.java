package br.edu.infnet.ApiJones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApiJonesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiJonesApplication.class, args);
	}

}
