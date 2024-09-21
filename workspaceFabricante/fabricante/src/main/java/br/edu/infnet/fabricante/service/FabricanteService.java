package br.edu.infnet.fabricante.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.fabricante.model.Fabricante;
import br.edu.infnet.fabricante.repository.FabricanteRepository;

@Service
public class FabricanteService {
	
	@Autowired
	private FabricanteRepository fabricanteRepository;
	
	public List<Fabricante> buscarTodosFabricantes(){
		return fabricanteRepository.findAll();
	}
	
	public void incluirFabricante(Fabricante fabricante) {
		fabricanteRepository.save(fabricante);
	}

	public Optional<Fabricante> buscaPeloId(Long id) {
		return fabricanteRepository.findById(id);
	}
	
	public void deletaPeloId(Long id) {
		 fabricanteRepository.deleteById(id);
	}
	
	public Fabricante atualizar(Fabricante fabricante) throws Exception {
		
		if(fabricante.getId() == null) {
			throw new Exception("O fabricante e não pode ser salvo na base");
		}
		Fabricante fabricanteAtualizado = fabricanteRepository.save(fabricante);
		return fabricanteAtualizado;
	}
	
}
