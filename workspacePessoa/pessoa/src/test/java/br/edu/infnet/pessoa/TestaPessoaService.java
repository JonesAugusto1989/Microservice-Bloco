package br.edu.infnet.pessoa;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import br.edu.infnet.pessoa.model.Endereco;
import br.edu.infnet.pessoa.model.Pessoa;
import br.edu.infnet.pessoa.service.PessoaService;

@SpringBootTest
public class TestaPessoaService {
	
	@Autowired
	private PessoaService pessoaService;
	
	Logger logger = LoggerFactory.getLogger(TestaPessoaService.class);
	
	@Test
	@DisplayName("Testa inclusão")
	public void testaInclusão() {
		
		
		LocalDate dataNasc = LocalDate.parse("1988-04-20"); 
		
		Endereco endereco = new Endereco("21351-050","Avenida Pau Ferro","335","Freguesia","Rio de Janeiro","RJ");
		
		Pessoa pessoa1 = new Pessoa("696.861.790-03","Ana Marta",endereco,dataNasc);
		
		pessoaService.salvarPessoa(pessoa1);
		
		Pessoa pessoa2 = pessoaService.findByCpfCnjp("696.861.790-03").get();
		

		assertEquals(pessoa1.getCpfCnpj(),pessoa2.getCpfCnpj());
		
	}
	
	@Test
	@DisplayName("Testa delete")
	public void testaDelete() {
		
		
		LocalDate dataNasc = LocalDate.parse("1988-04-20"); 
		
		Endereco endereco = new Endereco("21351-050","Avenida Pau Ferro","335","Freguesia","Rio de Janeiro","RJ");
		
		Pessoa pessoa1 = new Pessoa("696.861.790-03","Ana Marta",endereco,dataNasc);
		
		pessoaService.salvarPessoa(pessoa1);
		
		Pessoa pessoa2 = pessoaService.findByCpfCnjp("696.861.790-03").get();
		
		assertEquals(pessoa1.getCpfCnpj(),pessoa2.getCpfCnpj());
		pessoaService.deleteByCpfCnpj("696.861.790-03");
		Pessoa pessoa = pessoaService.findByCpfCnjp("696.861.790-03").get();
		assertEquals(null,pessoa);
		
	}
	
	@Test
	@DisplayName("Testa alteração")
	public void testaAlteracao() {
		
		
		LocalDate dataNasc = LocalDate.parse("1988-04-20"); 
		
		Endereco endereco = new Endereco("21351-050","Avenida Pau Ferro","335","Freguesia","Rio de Janeiro","RJ");
		
		Pessoa pessoa1 = new Pessoa("696.861.790-03","Ana Marta",endereco,dataNasc);
		
		pessoaService.salvarPessoa(pessoa1);
		
		
		LocalDate dataNasc2 = LocalDate.parse("2024-12-12"); 
		pessoa1.setDataNasc(dataNasc2);
		Pessoa pessoa2 = pessoaService.findByCpfCnjp("696.861.790-03").get();
		try {
			pessoaService.atualizar(pessoa1);
		} catch (Exception e) {
		
			e.printStackTrace();
		}

		assertNotEquals(pessoa1.getDataNasc(),pessoa2.getDataNasc());
		
	}

}
