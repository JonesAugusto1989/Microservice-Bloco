package br.edu.infnet.pessoa.client;

import java.util.Collection;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.pessoa.model.Endereco;



@FeignClient(name = "ApiJones-service")
public interface ApiJonesClient {

	@GetMapping("/listagem")
	Collection<String> obterLista();
	
	@GetMapping("/cep/{cep}")
	public Endereco obterPorCep(@PathVariable String cep);
	
	
}
