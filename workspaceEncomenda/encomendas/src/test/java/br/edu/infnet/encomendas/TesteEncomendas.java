package br.edu.infnet.encomendas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.infnet.encomendas.model.Encomenda;
import br.edu.infnet.encomendas.model.Encomendas;
import br.edu.infnet.encomendas.service.EncomendasService;

@SpringBootTest
public class TesteEncomendas {
	
	@Autowired
	private EncomendasService encomendasService;
	
	Logger logger = LoggerFactory.getLogger(TesteEncomendas.class);

	@Test
	@DisplayName("Testa inclusão")
	public void testaInclusão() {
		
		List<Encomenda> lista1 = new ArrayList<Encomenda>();
		Encomenda encomanda1 = new Encomenda(1l,1l);
		
		lista1.add(encomanda1);
		BigDecimal bg = new BigDecimal(150);
		Encomendas encomendas1 = new Encomendas("21.686.681/0001-22",lista1,bg);
		
		
		
		
		encomendasService.salvarEncomenda(encomendas1);
		
		Encomendas encomendas2 = encomendasService.findById(2l).get();
		

		assertEquals(encomendas1.getCpfCnpj(),encomendas2.getCpfCnpj());
		
	}
	
	@Test
	@DisplayName("Testa delete")
	public void testaDelete() {
		
		
		List<Encomenda> lista1 = new ArrayList<Encomenda>();
		Encomenda encomanda1 = new Encomenda(1l,1l);
		
		lista1.add(encomanda1);
		BigDecimal bg = new BigDecimal(150);
		Encomendas encomendas1 = new Encomendas("21.686.681/0001-22",lista1,bg);
		
		encomendasService.salvarEncomenda(encomendas1);
		
		Encomendas encomendas2 = encomendasService.findById(2l).get();
		
		
		encomendasService.deletaPeloId(2l);
		
		assertNotEquals(encomendas1.getCpfCnpj(),encomendas2.getCpfCnpj());
		
	}
	
	

}
	


