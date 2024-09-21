package br.edu.infnet.pessoa.model;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


public class Encomendas {

	private Long id;
	
	private String cpfCnpj;
	
	
	private List<Encomenda> listaDePecas;
	
	private BigDecimal valorTotal;
	
	
	
	public Encomendas() {
		
	}

	public List<Encomenda> getListaDePecas() {
		return listaDePecas;
	}

	public void setListaDePecas(List<Encomenda> listaDePecas) {
		this.listaDePecas = listaDePecas;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	@Override
	public String toString() {
		return "Encomendas [id=" + id + ", cpfCnpj=" + cpfCnpj + ", listaDePecas=" + listaDePecas + ", valorTotal="
				+ valorTotal + "]";
	}


	

}
