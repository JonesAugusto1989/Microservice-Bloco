package br.edu.infnet.encomendas.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


public class Pessoa {
	
	
	private String cpfCnpj;
	
	private String nome;
	
	private String Endereco;
	
	private LocalDate dataNasc;
	
	private long idPeca;
	
	private String peca;
	
	
	
	public Pessoa() {
		
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

	public String getEndereco() {
		return Endereco;
	}

	public void setEndereco(String endereco) {
		Endereco = endereco;
	}

	public LocalDate getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getPeca() {
		return peca;
	}

	public void setPeca(String peca) {
		this.peca = peca;
	}

	public long getIdPeca() {
		return idPeca;
	}

	public void setIdPeca(long idPeca) {
		this.idPeca = idPeca;
	}

	@Override
	public String toString() {
		return "Pessoa [cpfCnpj=" + cpfCnpj + ", nome=" + nome + ", Endereco=" + Endereco + ", dataNasc=" + dataNasc
				+ ", peca=" + peca + ", idPeca=" + idPeca + "]";
	}


	
	

}
