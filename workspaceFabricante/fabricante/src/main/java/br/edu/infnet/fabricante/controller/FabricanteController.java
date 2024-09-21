package br.edu.infnet.fabricante.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.fabricante.model.Fabricante;
import br.edu.infnet.fabricante.service.FabricanteService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/")
public class FabricanteController {
	
	@Autowired
	private FabricanteService fabricanteService;
	Logger logger = LoggerFactory.getLogger(FabricanteController.class);
	
	
	
	
	@Operation(summary = "Listar Todos",description = "Lista todos os Fabricantes", tags="Fabricante")
	@GetMapping
	public ResponseEntity<List<?>> buscarTodos(){
		
		return ResponseEntity.ok(fabricanteService.buscarTodosFabricantes());
	}
		
	@Operation(summary = "Busca um Fabricante ",description = "Busca um Fabricante por id", tags="Fabricante")
	@GetMapping("/buscaPorId/{id}")
	public ResponseEntity<?> buscaPorId(@PathVariable Long id){
		
		Optional<Fabricante> fabricanteFound = fabricanteService.buscaPeloId(id);
		logger.info("{} Buscou fabricante",fabricanteFound);
		if(!fabricanteFound.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado");
		}
		return ResponseEntity.ok(fabricanteFound.get());
	}
	
	@Operation(summary = "Incluir Fabricante",description = "Incluir um Fabricante", tags="Fabricante")	
	@PostMapping
	public ResponseEntity<?> incluir(Fabricante fabricante){
		logger.info("{} foi salvo",fabricante);
		fabricanteService.incluirFabricante(fabricante);
		return ResponseEntity.ok().build();
		
	}
	@Operation(summary = "Atualiza um fabricante",description = "Atualiza uma fabricante", tags="Fabricante")
	@PutMapping("/atualizar")
	public ResponseEntity<?> atualizaUmFabricante(@RequestBody Fabricante fabricante){
		try {
			
			fabricanteService.atualizar(fabricante);
			logger.info("{} foi atualizada. {}",fabricante);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(fabricante);
		} catch (Exception e) {
			
			logger.info("{} erro em atualizar. {}",fabricante ,e.getMessage());
			return ResponseEntity.badRequest().body("Erro ao atualizar"+e.getMessage());
		}	
	}
	
	@Operation(summary = "Deleta um Fabricante",description = "Deleta uma Fabricante por id", tags="Fabricante")
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<?> deletarPorId(@PathVariable Long id){
		
		Optional<Fabricante> fabricanteFound = fabricanteService.buscaPeloId(id);
		
		if(!fabricanteFound.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado");
		}
		
		fabricanteService.deletaPeloId(id);
		logger.info("{} foi deletada",fabricanteFound);
		return ResponseEntity.ok().build();
	}
	
	

}
