package br.edu.infnet.pessoa.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Pessoa {
	
	@Id
	@Column(name = "cpfCnpj")
	private String cpfCnpj;
	
	@Column(name="nome")
	private String nome;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="IDENDERECO")
	private Endereco endereco;
	
	@Column(name="dataNascimento")
	private LocalDate dataNasc;
	
	
	
	public Pessoa() {
		
		this.endereco = new Endereco();
	}



	public Pessoa(String cpfCnpj, String nome, Endereco endereco, LocalDate dataNasc) {
		this.cpfCnpj = cpfCnpj;
		this.nome = nome;
		this.endereco = endereco;
		this.dataNasc = dataNasc;
		this.endereco = endereco;
	}



	public String getCpfCnpj() {
		return cpfCnpj;
	}



	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public Endereco getEndereco() {
		return endereco;
	}



	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}



	public LocalDate getDataNasc() {
		return dataNasc;
	}



	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}

	@Override
	public String toString() {
		return "Pessoa [cpfCnpj=" + cpfCnpj + ", nome=" + nome + ", Endereco=" + endereco + ", dataNasc=" + dataNasc
				+ "]";
	}


}
