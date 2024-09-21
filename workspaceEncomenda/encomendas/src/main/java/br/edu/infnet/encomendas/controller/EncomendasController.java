package br.edu.infnet.encomendas.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.encomendas.model.Encomendas;
import br.edu.infnet.encomendas.service.EncomendasService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ExampleObject;

@RestController
@RequestMapping("/")
public class EncomendasController {

	@Autowired
	private EncomendasService encomendasService;
	Logger logger = LoggerFactory.getLogger(EncomendasController.class);
	

	
	@Operation(summary = "Listar Todos",description = "Lista todas as Pessoas", tags="Encomenda")
	@GetMapping
	public ResponseEntity<List<?>> buscarTodos(){
		
		return ResponseEntity.ok(encomendasService.listarEncomendas());
	}
	
	@Operation(summary = "Busca uma Encomenda",description = "Busca uma Encomenda por Id", tags="Encomenda")
	@GetMapping("/buscaPorId/{id}")
	public ResponseEntity<?> buscaPorId(@PathVariable Long id){
		
		Optional<Encomendas> encomendasFound = encomendasService.findById(id);
		
		if(!encomendasFound.isPresent()) {
			logger.info("Buscou o {} ",encomendasFound);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado");
		}
		return ResponseEntity.ok(encomendasFound.get());
	}
	
	@Operation(summary = "Incluir Encomenda",description = "Inclui uma Encomenda", tags="Encomenda")
	@PostMapping("/incluirEncomendas")
	public ResponseEntity<?> incluir(@RequestBody Encomendas encomendas){
		
		encomendasService.salvarEncomenda(encomendas);;
		logger.info("{} foi salva",encomendas);
		return ResponseEntity.ok().build();
		
	}
	
	@Operation(summary = "Deleta uma Encomenda",description = "Deleta uma Encomenda por Id", tags="Encomenda")
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<?> deletarPorId(@PathVariable Long id){
		
		Optional<Encomendas> encomendasFound = encomendasService.findById(id);
		
		if(!encomendasFound.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado");
		}
		
		encomendasService.deletaPeloId(id);
		logger.info("{} foi deletada",encomendasFound);
		return ResponseEntity.ok().build();
	}
	
	@Operation(summary = "Busca todas as Encomendas",description = "Busca todas as Encomendas por CPF/CNPJ", tags="Encomenda")
	@GetMapping("/buscarPorTodasCpfCnpj/{CpfCnpj}")
	public ResponseEntity<Collection<Encomendas>> findAllByCpfCnpj(@PathVariable("CpfCnpj") String cpfCnpj){
		logger.info("{} Buscando encomendas do Cpf/Cnpj",cpfCnpj);
		return ResponseEntity.ok(encomendasService.findAllByCpfCnpj(cpfCnpj));
	}
	
	
	
	
}
