package br.edu.infnet.peca;



import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.infnet.peca.model.Peca;
import br.edu.infnet.peca.service.PecaService;

@SpringBootTest
public class PecaServiceTestes {
	
	@Autowired
	private PecaService pecaService;
	
	Logger logger = LoggerFactory.getLogger(PecaServiceTestes.class);
	
	@Test
	@DisplayName("Testa inclusão")
	public void testaInclusão() {
		
		
		BigDecimal bg = new BigDecimal(100);
		Peca peca1 = new Peca("Jogo de pneus",bg,"50kgs","1metro",1l,"Pirelli");
		
		
		pecaService.salvarPeca(peca1);
		
		Peca peca2 = pecaService.findById(5l).get();
		

		assertEquals(peca1.getId(),peca2.getId());
		
	}
	
	@Test
	@DisplayName("Testa delete")
	public void testaDelete() {
		
		
		BigDecimal bg = new BigDecimal(100);
		Peca peca1 = new Peca("Jogo de pneus",bg,"50kgs","1metro",1l,"Pirelli");
		
		pecaService.salvarPeca(peca1);
		
		
		
		pecaService.deleteById(5l);
		Peca peca2 = pecaService.findById(5l).get();
		assertNotEquals(peca1.getId(),peca2.getId());
		
	}
	
	@Test
	@DisplayName("Testa alteração")
	public void testaAlteracao() {
		
		
		
		BigDecimal bg = new BigDecimal(100);
		Peca peca1 = new Peca("Jogo de pneus",bg,"50kgs","1metro",1l,"Pirelli");
		
		
		pecaService.salvarPeca(peca1);
		
		Peca peca2 = pecaService.findById(5l).get();
		peca1.setFabricante("Goldeye");

		assertEquals(peca1.getId(),peca2.getId());
		try {
			pecaService.atualizar(peca1);
		} catch (Exception e) {
		
			e.printStackTrace();
		}

		assertNotEquals(peca1.getFabricante(),peca2.getFabricante());
		
	}

}
