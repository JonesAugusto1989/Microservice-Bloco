package br.edu.infnet.ApiJones.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.ApiJones.model.Endereco;

@FeignClient(url = "https://viacep.com.br/ws",name = "viaCep" )
public interface EnderecoClient {

	@GetMapping("/{cep}/json/")
	Endereco obterPorCep(@PathVariable String cep);
	
	
	
}
