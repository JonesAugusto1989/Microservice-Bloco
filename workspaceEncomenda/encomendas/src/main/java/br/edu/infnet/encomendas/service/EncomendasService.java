package br.edu.infnet.encomendas.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.encomendas.model.Encomenda;
import br.edu.infnet.encomendas.model.Encomendas;
import br.edu.infnet.encomendas.model.Peca;
import br.edu.infnet.encomendas.repository.EncomendasRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class EncomendasService {
	
	@Autowired
	private EncomendasRepository encomendasRepository;
	
	@Autowired
	private PecaService pecaService;
	
	
	
	public List<Encomendas> listarEncomendas() {
		return encomendasRepository.findAll();
	}
	
	public void salvarEncomenda(Encomendas encomendas) {
		
		
		BigDecimal valorTotal = encomendas.getListaDePecas().stream().map(this::calcularPrecoTotal).reduce(BigDecimal.ZERO, BigDecimal::add);
		encomendas.setValorTotal(valorTotal);
		
		encomendasRepository.save(encomendas);
	}
	
	public Optional<Encomendas> findById(Long id){
		return encomendasRepository.findById(id);
	}
	
	public void deletaPeloId(Long id) {
		encomendasRepository.deleteById(id);
	}
	
	@CircuitBreaker(name = "pecaService")
	@Retry(name = "pecaServiceRetry")
	public BigDecimal calcularPrecoTotal(Encomenda encomenda) {
		
		Peca peca = pecaService.getById(encomenda.getPecaId());
		BigDecimal valorTotal = peca.getPreco().multiply(new BigDecimal(encomenda.getQuantidade()));
			
		return valorTotal;
	}
	
	
	public Collection<Encomendas> findAllByCpfCnpj(String cpfCnpj){
	
		Collection<Encomendas> listaDeEncomendas = encomendasRepository.findAllByCpfCnpj(cpfCnpj);
		
		if(listaDeEncomendas == null) {
			 listaDeEncomendas = new ArrayList<>();
		}
			
		return listaDeEncomendas;
		
	}
	
	
}
