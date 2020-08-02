package br.com.deveficiente.casadocodigo.categoria;

import javax.validation.constraints.NotBlank;

import br.com.deveficiente.casadocodigo.compartilhado.UniqueValue;

public class NovaCategoriaRequest {
	
	@NotBlank
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome")
	private String nome;

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
