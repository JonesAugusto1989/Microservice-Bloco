package br.edu.infnet.pessoa.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.edu.infnet.pessoa.client.EncomendasClient;
import br.edu.infnet.pessoa.model.Encomendas;
import br.edu.infnet.pessoa.model.Pessoa;
import br.edu.infnet.pessoa.repository.PessoaRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private EncomendasClient encomendaClient; 
	
	Logger logger = LoggerFactory.getLogger(PessoaService.class);
	
	public PessoaService(PessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
	}
	
	
	public List<Pessoa> findAll() {
		return pessoaRepository.findAll();
	}
	
	public void salvarPessoa(Pessoa pessoa) {
		pessoaRepository.save(pessoa);
	}
	
	public Optional<Pessoa> findByCpfCnjp(String cpfCnpj) {
		return pessoaRepository.findByCpfCnpj(cpfCnpj);
	}

	public void deleteByCpfCnpj(String cpfCnpj) {
		 pessoaRepository.deleteByCpfCnpj(cpfCnpj);
	}
	
	
	public Pessoa atualizar(Pessoa pessoa) throws Exception {
		
		if(pessoa.getCpfCnpj()== null) {
			throw new Exception("A pessoa e não pode ser salvo na base");
		}
		Pessoa pessoaAtualizada = pessoaRepository.save(pessoa);
		return pessoaAtualizada;
	}
	
	
	@CircuitBreaker(name = "pessoaService", fallbackMethod = "fallbackPegarEncomendas")
	@Retry(name = "pessoaServiceRetry")
	@Cacheable("encomendas")
	public Collection<Encomendas> pegarEncomendas(String cpfCnpj) {
		
		Collection<Encomendas> listaDeEncomendas = new ArrayList<Encomendas>();
		
		return listaDeEncomendas = encomendaClient.findAllByCpfCnpj(cpfCnpj);
	}
	
	public Collection<Encomendas> fallbackPegarEncomendas(String cpfCnpj, Throwable t) {
		logger.info("{} Serviço de Encomendas Fora do Ar!",cpfCnpj);
		Collection<Encomendas> listaDeEncomendas = new ArrayList<Encomendas>();
		return listaDeEncomendas;
	}
	
}
