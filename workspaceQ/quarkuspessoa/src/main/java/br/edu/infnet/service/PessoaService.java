package br.edu.infnet.service;

import java.util.List;
import java.util.Optional;

import br.edu.infnet.model.Pessoa;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PessoaService {

	public Pessoa criarPessoa(Pessoa pessoa) {
		 Pessoa.persist(pessoa);
		 return pessoa;
		
	}
	
	public List<Pessoa> listarPessoas(){
		return Pessoa.listAll();
	}
	
	public Optional<Pessoa> findById(String cpfCnpj) {
		return Pessoa.findByIdOptional(cpfCnpj);
	
	}
	
	public Pessoa atualizarPessoa(Pessoa pessoa) {
		
		Pessoa pessoaFound = findById(pessoa.cpfCnpj).get();
		
		pessoaFound.nome = pessoa.nome;
		pessoaFound.email = pessoa.email;
		Pessoa.persist(pessoaFound);
		
		return pessoaFound; 	
	}
	
	public void deleteById(String cpfCnpj) {
		Pessoa.deleteById(cpfCnpj);
	}
}