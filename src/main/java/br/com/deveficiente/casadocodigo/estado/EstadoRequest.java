package br.com.deveficiente.casadocodigo.estado;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import br.com.deveficiente.casadocodigo.Pais.Pais;

public class EstadoRequest {

	@NotNull
	@NotBlank
	private String nome;
	private Long idPais;

	public EstadoRequest(@NotNull @NotBlank String nome, Long idPais) {
		this.nome = nome;
		this.idPais = idPais;
	}

	public Estado toModel(EntityManager manager) {
		Pais possivelPais = manager.find(Pais.class, idPais);
		if(possivelPais==null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "País não encontrado");
		}
		
		return new Estado(nome, possivelPais);
	}
}
