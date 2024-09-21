package br.edu.infnet.config;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import jakarta.ws.rs.core.Application;

@OpenAPIDefinition(
		    info = @Info(
		        title="Projeto Quarkus",
		        version = "1.0.0",
		        contact = @Contact(
		            name = "Projeto Quarkus",
		            url = "https://www.infnet.edu.br/infnet/",
		            email = "jones.paranhos@hotmail.com.com")
	))


public class ApplicationQuarkus extends Application{

}
