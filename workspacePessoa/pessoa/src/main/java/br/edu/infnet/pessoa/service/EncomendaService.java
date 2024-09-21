package br.edu.infnet.pessoa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.pessoa.client.EncomendasClient;
import br.edu.infnet.pessoa.model.Encomenda;

@Service
public class EncomendaService {

	@Autowired
	EncomendasClient encomendaClient;
	
	
	public Encomenda buscaPorId(Long id){
		return encomendaClient.buscaPorId(id);
	}
	
	
	
}
