package br.edu.infnet.peca.model;

public class Fabricante {
	
	
	private Long id;
	
	private String nome;
	
	private String cnpj;
	
	private String origem;
	
	private Boolean multinacional;

	public Fabricante() {
		
	}

	public Fabricante(Long id, String nome, String cnpj, String origem, Boolean multinacional) {
		super();
		this.id = id;
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
