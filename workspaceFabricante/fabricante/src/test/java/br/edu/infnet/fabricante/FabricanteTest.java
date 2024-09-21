package br.edu.infnet.fabricante;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.infnet.fabricante.model.Fabricante;
import br.edu.infnet.fabricante.service.FabricanteService;

@SpringBootTest
public class FabricanteTest {

	@Autowired
	private FabricanteService fabricanteService;
	
	Logger logger = LoggerFactory.getLogger(FabricanteTest.class);
	
	@Test
	@DisplayName("Testa inclusão")
	public void testaInclusão() {
		
		Fabricante fabricante1 = new Fabricante("Fabrica João do Kwid","21.686.681/0001-22","Brazil",false);
		
		
		
		fabricanteService.incluirFabricante(fabricante1);
		
		Fabricante fabricante2 = fabricanteService.buscaPeloId(5l).get();
		

		assertEquals(fabricante1.getCnpj(),fabricante2.getCnpj());
		
	}
	
	@Test
	@DisplayName("Testa delete")
	public void testaDelete() {
		
		
		Fabricante fabricante1 = new Fabricante("Fabrica João do Kwid","21.686.681/0001-22","Brazil",false);
		
		fabricanteService.incluirFabricante(fabricante1);
		
		Fabricante fabricante2 = fabricanteService.buscaPeloId(5l).get();
		
		
		assertEquals(fabricante1.getCnpj(),fabricante2.getCnpj());
		
		fabricanteService.deletaPeloId(5l);
		fabricante2 = fabricanteService.buscaPeloId(5l).get();
		assertEquals(null,fabricante2);
		
	}
	
	@Test
	@DisplayName("Testa alteração")
	public void testaAlteracao() {
		
		
		
		Fabricante fabricante1 = new Fabricante("Fabrica João do Kwid","21.686.681/0001-22","Brazil",false);
		
		fabricanteService.incluirFabricante(fabricante1);
		Fabricante fabricante2 = fabricanteService.buscaPeloId(5l).get();
		fabricante1.setMultinacional(true);
		
		try {
		
			fabricanteService.atualizar(fabricante1);
		} catch (Exception e) {
		
			e.printStackTrace();
		}

		assertNotEquals(fabricante1.getMultinacional(),fabricante2.getMultinacional());
		
	}
	
}
