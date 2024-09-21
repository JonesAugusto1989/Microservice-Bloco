package br.edu.infnet.pessoa.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


public class Encomenda {
	
	
	private long quantidade;
	private long pecaId;
	
	public Encomenda() {
		
	}
	
	public Long getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}
	public Long getPecaId() {
		return pecaId;
	}
	public void setPecaId(Long pecaId) {
		this.pecaId = pecaId;
	}
	
	@Override
	public String toString() {
		return "Encomenda [quantidade=" + quantidade + ", pecaId=" + pecaId + "]";
	}
	
}
