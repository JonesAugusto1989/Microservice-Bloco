package br.edu.infnet.encomendas.model;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Encomendas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String cpfCnpj;
	
	@ElementCollection
	private List<Encomenda> listaDePecas;
	
	private BigDecimal valorTotal;
	
	
	
	public Encomendas() {
		
	}

	public Encomendas(String cpfCnpj, List<Encomenda> listaDePecas, BigDecimal valorTotal) {
		this.cpfCnpj = cpfCnpj;
		this.listaDePecas = listaDePecas;
		this.valorTotal = valorTotal;
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
