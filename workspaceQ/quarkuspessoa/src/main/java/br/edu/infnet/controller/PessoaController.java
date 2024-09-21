package br.edu.infnet.controller;



import java.util.List;

import org.eclipse.microprofile.openapi.annotations.Operation;

import br.edu.infnet.model.Pessoa;
import br.edu.infnet.service.PessoaService;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PessoaController {
	
	private final PessoaService pessoaService;
	
	
	
	public PessoaController(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}
	
	@Operation(summary = "Listar Pessoas", description = "Lista Todas as pessoas")
	@GET
	public Response listarPessoas() {
		List<Pessoa> listaDePessoas = pessoaService.listarPessoas();
		return Response.ok(listaDePessoas).build();
	}
	
	@Operation(summary = "Buscar Pessoas", description = "Busca uma pessoa utilizando CpfCnpj")
	@GET
	@Path("/{CpfCnpj}")
	public Response findByCpfCnpj(@PathParam("CpfCnpj") String CpfCnpj) {
		try {
			Pessoa pessoa = pessoaService.findById(CpfCnpj).get();
			return Response.ok(pessoa).build();
		}catch(Exception e) {
			return Response.noContent().status(Status.NOT_FOUND).entity(e.getMessage()).build();
		}
		
	}
	
	@Operation(summary = "Criar Pessoa", description = "Cria uma pessoa")
	@POST
	@Transactional
	public Response criarUsuario(Pessoa pessoa) {
		
		return Response.ok(pessoaService.criarPessoa(pessoa)).build();
	}
	
	
	@Operation(summary = "Atualizar Pessoa", description = "Atualiza uma pessoa utilizando CpfCnpj")
	@PUT
	@Transactional
	@Path("/{CpfCnpj}")
	public Response atualizarPessoa(@PathParam("CpfCnpj")String CpfCnpj, Pessoa pessoa) {
		try {
			
			return Response.ok(pessoaService.atualizarPessoa(pessoa)).build();
		}catch(Exception e) {
			return Response.noContent().status(Status.NOT_FOUND).entity(e.getMessage()).build();
		}
	}
	
	@Operation(summary = "Deletar Pessoa", description = "Deleta uma pessoa utilizando CpfCnpj")
	@DELETE
	@Transactional
	@Path("/{CpfCnpj}")
	public Response deletarPessoa(@PathParam("CpfCnpj") String CpfCnpj) {
		try {
			
			return Response.ok(Pessoa.deleteById(CpfCnpj)).build();
		}catch(Exception e) {
			return Response.noContent().status(Status.NOT_FOUND).entity(e.getMessage()).build();
		}
	}
}


