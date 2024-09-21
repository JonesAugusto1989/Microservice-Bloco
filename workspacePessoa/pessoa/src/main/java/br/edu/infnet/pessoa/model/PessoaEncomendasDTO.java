package br.edu.infnet.pessoa.model;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;

	public record PessoaEncomendasDTO( @Schema(description = "Pessoa", example = "{'nome': 'Marta Silva', 'cpf': '518.307.090-38'}")Pessoa pessoa,
		Collection<Encomendas> encomenda
		) {

		
}
