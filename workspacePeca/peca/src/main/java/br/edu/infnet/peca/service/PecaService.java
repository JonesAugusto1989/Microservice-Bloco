package br.edu.infnet.peca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.peca.model.Peca;
import br.edu.infnet.peca.repository.PecaRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class PecaService {
	
	@Autowired
	private PecaRepository pecaRepository;
	
	
	
	public List<Peca> listarPecas() {
		return pecaRepository.findAll();
	}
	
	public void salvarPeca(Peca peca) {
		pecaRepository.save(peca);
	}
	
	public Optional<Peca> findById(Long id){
		return pecaRepository.findById(id);
	}
	@CircuitBreaker(name="fabricanteFindByIdCircuitBreak")
	@Retry(name = "fabricanteFindByIdRetry")
	public Optional<Peca> findByIdCompleto(Long id){
		
		
		return pecaRepository.findById(id);
	}
	
	public void deleteById(long id) {
		pecaRepository.deleteById(id);
	}
	
	public Peca atualizar(Peca peca) throws Exception {
		
		if(peca.getId() == null) {
			throw new Exception("A peca  e não pode ser salvo na base");
		}
		Peca pecaAtualizada = pecaRepository.save(peca);
		return pecaAtualizada;
	}
	
	
}
