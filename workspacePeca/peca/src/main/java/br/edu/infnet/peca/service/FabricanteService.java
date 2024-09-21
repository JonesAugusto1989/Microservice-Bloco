package br.edu.infnet.peca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.infnet.peca.client.FabricanteClient;
import br.edu.infnet.peca.model.Fabricante;

@Service
public class FabricanteService {
	
	@Autowired
	private FabricanteClient fabricanteClient;
	
	public Fabricante buscaPorId(Long id) {
		
		return fabricanteClient.buscaPorId(id);
		
	}

}
