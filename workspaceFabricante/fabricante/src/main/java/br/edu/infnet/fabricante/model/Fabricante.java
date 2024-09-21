package br.edu.infnet.fabricante.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity
public class Fabricante {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@Size(min=3)
	private String nome;
	
	@Size(min=14 ,max=18)
	private String cnpj;
	
	@Size(min=2,max=20)
	private String origem;
	
	private Boolean multinacional;

	public Fabricante() {
		
	}

	public Fabricante( String nome, String cnpj, String origem, Boolean multinacional) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.origem = origem;
		this.multinacional = multinacional;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public Boolean getMultinacional() {
		return multinacional;
	}

	public void setMultinacional(Boolean multinacional) {
		this.multinacional = multinacional;
	}

	@Override
	public String toString() {
		return "Fabricante [id=" + id + ", nome=" + nome + ", cnpj=" + cnpj + ", origem=" + origem + ", multinacional="
				+ multinacional + "]";
	}

	
	
}
