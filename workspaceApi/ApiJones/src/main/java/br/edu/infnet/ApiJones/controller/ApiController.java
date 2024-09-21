package br.edu.infnet.ApiJones.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import br.edu.infnet.ApiJones.model.Endereco;
import br.edu.infnet.ApiJones.service.EnderecoService;


@RestController
public class ApiController {
	
	
	@Autowired
	private EnderecoService enderecoService;
	


	@GetMapping("/cep/{cep}")
	public Endereco obterPorCep(@PathVariable String cep) {
		
		return enderecoService.obterPorCep(cep);
	}
	

	
	
}
