package br.edu.infnet.peca.controller;

import java.util.Optional;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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

import br.edu.infnet.peca.model.Fabricante;
import br.edu.infnet.peca.model.Peca;
import br.edu.infnet.peca.model.PecaFabricanteRecord;
import br.edu.infnet.peca.service.FabricanteService;
import br.edu.infnet.peca.service.PecaService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/")
public class PecaController {

	@Autowired
	private PecaService pecaService;
	
	@Autowired
	private FabricanteService fabricanteService;
	
	Logger logger = LoggerFactory.getLogger(PecaController.class);
	
	
	@Operation(summary = "Listar Todos",description = "Lista todas as Peça", tags="Peça")
	@GetMapping("/")
	public ResponseEntity<?> listarTodos() {
		return ResponseEntity.ok(pecaService.listarPecas());
	}
	
	@Operation(summary = "Incluir Peça",description = "Incluir uma Peça", tags="Peça")
	@PostMapping("/incluiPeca")
	public ResponseEntity<?> incluirPessoa(@RequestBody Peca peca) {
		
		try {
			pecaService.salvarPeca(peca);
			logger.info("{} foi salva",peca);
			return ResponseEntity.ok(true);
		}catch(Exception e) {
			return ResponseEntity.internalServerError().body(false);
		}
		
	}
	@Operation(summary = "Atualiza uma Peça",description = "Atualiza uma peça", tags="Peça")
	@PutMapping("/atualizar")
	public ResponseEntity<?> atualizaUmaPeca(@RequestBody Peca peca){
		try {
			
			pecaService.atualizar(peca);
			logger.info("{} foi atualizada. {}",peca);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(peca);
		} catch (Exception e) {
			
			logger.info("{} erro em atualizar. {}",peca ,e.getMessage());
			return ResponseEntity.badRequest().body("Erro ao atualizar"+e.getMessage());
		}	
	}
	
	@Operation(summary = "Busca uma Peça",description = "Busca uma Peça por Id", tags="Peça")
	@GetMapping("/buscaPorId/{id}")
	public ResponseEntity<?> buscaPorId(@PathVariable("id") Long id){
		
		Optional<Peca> pecaFound = pecaService.findById(id);
		
		logger.info("Buscando a peça: {} ",pecaFound);
		if(pecaFound.isPresent()) {
			return ResponseEntity.ok(pecaFound.get());
		}else {
			return ResponseEntity.notFound().build();
		}	
	}
	
	
	@Operation(summary = "Busca uma Peça Completo",description = "Busca uma Peça e Fabricante por Id", tags="Peça")
	@GetMapping("/buscaPorId/{id}/Completo")
	public ResponseEntity<?> buscaPorIdCompleto(@PathVariable("id") Long id){
		
		Optional<Peca> pecaFound = pecaService.findByIdCompleto(id);
		logger.info("{} Buscou peça",pecaFound);
		if(pecaFound.isPresent()) {
			
			Fabricante fabricanteFound = fabricanteService.buscaPorId(pecaFound.get().getIdFabricante());
			logger.info("{} Buscou o fabricante",fabricanteFound);
			PecaFabricanteRecord PecaCompleta = new PecaFabricanteRecord(pecaFound.get(),fabricanteFound);		
			return ResponseEntity.ok(PecaCompleta);
		}else {
			return ResponseEntity.notFound().build();
		}	
	}
	
	@Operation(summary = "Deleta uma Peça",description = "Deleta uma Peça por Id", tags="Peça")
	@DeleteMapping("deletar/{id}")
	public ResponseEntity<?> deletarPorId(@PathVariable("id") Long id){
		
		Optional<Peca> pecaFound = pecaService.findById(id);
		
		if(pecaFound.isPresent()) {
			pecaService.deleteById(id);
			logger.info("{} foi deletada",pecaFound);
			return ResponseEntity.ok().body(String.format("%s Deletado com sucesso",pecaFound.get()));
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	
}
