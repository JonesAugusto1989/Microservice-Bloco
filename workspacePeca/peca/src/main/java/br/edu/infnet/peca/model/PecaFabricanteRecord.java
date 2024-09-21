package br.edu.infnet.peca.model;

import java.math.BigDecimal;

public record PecaFabricanteRecord(   
		Long pecaId,
	    String pecaNome,
	    BigDecimal pecaPreco,
	    String pecaPeso,
	    String pecaTamanho,
	    Long fabricanteId,
	    String fabricanteNome,
	    String fabricanteCnpj,
	    String fabricanteOrigem,
	    Boolean fabricanteMultinacional) {
	
	public PecaFabricanteRecord(Peca peca,Fabricante fabricante) {
		this(
				peca.getId(), 
				peca.getNome(),
				peca.getPreco(),
				peca.getPeso(), 
				peca.getTamanho(), 
				fabricante.getId(), 
				fabricante.getNome(), 
				fabricante.getCnpj(), 
				fabricante.getOrigem(),
				fabricante.getMultinacional());
	}
	

}
