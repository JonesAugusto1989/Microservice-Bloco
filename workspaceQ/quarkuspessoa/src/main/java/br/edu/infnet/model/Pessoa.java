package br.edu.infnet.model;

import java.time.LocalDate;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Pessoa extends PanacheEntityBase{
	
	
	@Id
	@Column(name = "cpfCnpj")
	public String cpfCnpj;
	
	@Column(name="nome")
	public String nome;
	
	
//	@Column(name="dataNascimento")
//	public LocalDate dataNasc;
//	
	public String email;

	
	
	
	

}
