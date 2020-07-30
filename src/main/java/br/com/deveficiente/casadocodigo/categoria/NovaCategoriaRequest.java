package br.com.deveficiente.casadocodigo.categoria;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaRequest {
	
	@NotBlank
	private String nome;

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
