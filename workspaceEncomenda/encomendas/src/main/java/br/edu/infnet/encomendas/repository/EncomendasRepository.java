package br.edu.infnet.encomendas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import br.edu.infnet.encomendas.model.Encomendas;

@Repository
public interface EncomendasRepository extends JpaRepository<Encomendas, Long>{
	
	List<Encomendas> findAllByCpfCnpj(String cpfCnpj);

}
