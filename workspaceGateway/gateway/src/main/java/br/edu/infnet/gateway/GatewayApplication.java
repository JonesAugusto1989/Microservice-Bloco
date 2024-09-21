package br.edu.infnet.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;



@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
	
	 @Bean
	 public RouteLocator routeLocator(RouteLocatorBuilder builder) {
	  return builder
	    .routes()
	    .route(r -> r.path("/pessoa-service/v3/api-docs").and().method(HttpMethod.GET).uri("lb://pessoa-service"))
	    .route(r -> r.path("/peca-service/v3/api-docs").and().method(HttpMethod.GET).uri("lb://peca-service"))
	    .route(r -> r.path("/fabrica-service/v3/api-docs").and().method(HttpMethod.GET).uri("lb://fabrica-service"))
	    .route(r -> r.path("/encomendas-service/v3/api-docs").and().method(HttpMethod.GET).uri("lb://encomendas-service"))
	    .build();
	 }

}












