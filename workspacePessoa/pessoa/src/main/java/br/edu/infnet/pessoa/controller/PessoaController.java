package br.edu.infnet.pessoa.controller;

import java.util.Collection;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.pessoa.client.ApiJonesClient;
import br.edu.infnet.pessoa.client.EncomendasClient;
import br.edu.infnet.pessoa.model.Encomendas;
import br.edu.infnet.pessoa.model.Endereco;
import br.edu.infnet.pessoa.model.Pessoa;
import br.edu.infnet.pessoa.model.PessoaEncomendasDTO;
import br.edu.infnet.pessoa.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/")
public class PessoaController {
	
	
	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private EncomendasClient encomendaClient;
	
	@Autowired
	private ApiJonesClient apiJonesClient;
	
	Logger logger = LoggerFactory.getLogger(PessoaController.class);
	
	
	
	@Operation(summary = "Listar Todos",description = "Lista todas as Pessoas", tags="Pessoa")
	@GetMapping("/")
	public ResponseEntity<?> listarTodos() {
		return ResponseEntity.ok(pessoaService.findAll());
	}
	
	@Operation(summary = "Incluir Pessoa",description = "Incluir uma Pessoa", tags="Pessoa")
	@PostMapping("/incluirPessoa")
	public ResponseEntity<?> incluirPessoa(@RequestBody Pessoa pessoa) {
		
		try {
			
			String cep = pessoa.getEndereco().getCep();
			String complemento = pessoa.getEndereco().getComplemento();
			
			Endereco endereco = apiJonesClient.obterPorCep(cep);
			endereco.setComplemento(complemento);
			
			pessoa.setEndereco(endereco);
			pessoaService.salvarPessoa(pessoa);
			logger.info("{} foi salva e tem o endereco {}",pessoa,pessoa.getEndereco());
			return ResponseEntity.status(HttpStatus.CREATED).body(pessoa);
		}catch(Exception e) {
			logger.info("{} não foi salva",pessoa);
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
		
	}
	
	@Operation(summary = "Atualiza uma Pessoa",description = "Atualiza  uma Pessoa por CPF/CNPJ", tags="Pessoa")
	@PutMapping("/atualizar")
	public ResponseEntity<?> atualizarUmaPessoa(@RequestBody Pessoa pessoa){
		try {
			String cep = pessoa.getEndereco().getCep();
			String complemento = pessoa.getEndereco().getComplemento();
			
			Endereco endereco = apiJonesClient.obterPorCep(cep);
			endereco.setComplemento(complemento);
			
			pessoa.setEndereco(endereco);
			pessoaService.atualizar(pessoa);
			logger.info("{} foi atualizada. {}",pessoa);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(pessoa);
		} catch (Exception e) {
			
			logger.info("{} erro em atualizar. {}",pessoa ,e.getMessage());
			return ResponseEntity.badRequest().body("Erro ao atualizar"+e.getMessage());
		}	
	}
	
	@Operation(summary = "Busca uma Pessoa Completo",description = "Busca uma Pessoa por CPF/CNPJ", tags="Pessoa")
	@GetMapping("/buscaPorId/{cpfCnpj}")
	public ResponseEntity<?> buscaPorId(@PathVariable("cpfCnpj") String cpfCnpj ){
		
		Optional<Pessoa> pessoaFound = pessoaService.findByCpfCnjp(cpfCnpj);
		
		if(pessoaFound.isPresent()) {
			return ResponseEntity.ok(pessoaFound.get());
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@Operation(summary = "Busca uma Pessoa Completo",description = "Busca uma Pessoa e Encomendas por CPF/CNPJ", tags="Pessoa")
	@GetMapping("/buscaPorId/{cpfCnpj}/Encomendas")
	public ResponseEntity<?> buscaPorIdCompleto(@PathVariable("cpfCnpj") String cpfCnpj){
		
		Optional<Pessoa> pessoaFound = pessoaService.findByCpfCnjp(cpfCnpj);
		
		if(pessoaFound.isPresent()) {
			Collection<Encomendas> listaDeEncomendas = pessoaService.pegarEncomendas(pessoaFound.get().getCpfCnpj());
			
			PessoaEncomendasDTO pessoaEncomenda = new PessoaEncomendasDTO(pessoaFound.get(), listaDeEncomendas);
			logger.info("{} buscando Pessoa e Encomendas",pessoaEncomenda);
			return ResponseEntity.ok(pessoaEncomenda);
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@Operation(summary = "Deleta uma Pessoa",description = "Deleta uma Pessoa por CPF/CNPJ", tags="Pessoa")
	@DeleteMapping("/deletar/{cpfCnpj}")
	public ResponseEntity<?> deletarPorId(@PathVariable("cpfCnpj") String cpfCnpj){
		Optional<Pessoa> pessoaFound = pessoaService.findByCpfCnjp(cpfCnpj);
		
		if(pessoaFound.isPresent()) {
			pessoaService.deleteByCpfCnpj(cpfCnpj);
			logger.info("{} foi deletada",pessoaFound);
			return ResponseEntity.ok().body("Deletado com sucesso");
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	
	
}
