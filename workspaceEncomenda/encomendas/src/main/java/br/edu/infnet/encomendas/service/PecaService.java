package br.edu.infnet.encomendas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import br.edu.infnet.encomendas.client.PecaClient;
import br.edu.infnet.encomendas.model.Peca;

@Service
public class PecaService {
	
	@Autowired
	private PecaClient pecaClient;

	public Peca getById(Long pecaId) {
		return pecaClient.buscaPorId(pecaId);
	}

}
