package br.edu.infnet.peca.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Peca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nome;
	
	private BigDecimal preco;
	
	private String peso;
	
	private String tamanho;
	
	private long idFabricante;
	
	private String Fabricante;
	
	public Peca() {
		
	}


	public Peca(String nome, BigDecimal preco, String peso, String tamanho, Long idFabricante,
			String fabricante) {

		this.nome = nome;
		this.preco = preco;
		this.peso = peso;
		this.tamanho = tamanho;
		this.idFabricante = idFabricante;
		this.Fabricante = fabricante;
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

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public Long getIdFabricante() {
		return idFabricante;
	}

	public void setIdFabricante(Long idFabricante) {
		this.idFabricante = idFabricante;
	}

	public String getFabricante() {
		return Fabricante;
	}

	public void setFabricante(String fabricante) {
		Fabricante = fabricante;
	}

	@Override
	public String toString() {
		return "Peca [id=" + id + ", nome=" + nome + ", preco=" + preco + ", peso=" + peso + ", tamanho=" + tamanho
				+ ", idFabricante=" + idFabricante + ", Fabricante=" + Fabricante + "]";
	}
	
}
