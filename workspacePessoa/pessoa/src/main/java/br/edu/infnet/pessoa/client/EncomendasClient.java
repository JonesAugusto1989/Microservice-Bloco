package br.edu.infnet.pessoa.client;

import java.util.Collection;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.pessoa.model.Encomenda;
import br.edu.infnet.pessoa.model.Encomendas;

@FeignClient(name = "encomendas-service")
public interface EncomendasClient {
	
	@GetMapping("/buscaPorId/{id}")
	Encomenda buscaPorId(@PathVariable Long id);
	
	@GetMapping("/buscarPorTodasCpfCnpj/{CpfCnpj}")
	Collection<Encomendas> findAllByCpfCnpj(@PathVariable("CpfCnpj") String cpfCnpj);

}
