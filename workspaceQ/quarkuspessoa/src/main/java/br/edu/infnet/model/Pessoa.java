package br.edu.infnet.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Pessoa extends PanacheEntityBase{
	
	
	@Id
	@Column(name = "cpfCnpj")
	public String cpfCnpj;
	
	@Column(name="nome")
	public String nome;
	

	public String email;

}
