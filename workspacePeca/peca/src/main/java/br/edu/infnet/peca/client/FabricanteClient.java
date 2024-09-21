package br.edu.infnet.peca.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.peca.model.Fabricante;

@FeignClient(name = "fabricante-service")
public interface FabricanteClient {
	
	@GetMapping
	List<Fabricante> buscarTodos();
	
	@GetMapping("/buscaPorId/{id}")
	Fabricante buscaPorId(@PathVariable Long id);

}
