package br.edu.infnet.encomendas.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.encomendas.model.Peca;

@FeignClient(name = "peca-service")
public interface PecaClient {
	
	@GetMapping
	List<Peca> listarPecas();
	
	@GetMapping("/buscaPorId/{id}")
	Peca buscaPorId (@PathVariable("id") Long id);
	

}
