package br.edu.infnet.fabricante.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.fabricante.model.Fabricante;

@Repository
public interface FabricanteRepository extends JpaRepository<Fabricante, Long>{

	

}
