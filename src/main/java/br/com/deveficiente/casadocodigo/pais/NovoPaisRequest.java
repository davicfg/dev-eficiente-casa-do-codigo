package br.com.deveficiente.casadocodigo.pais;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.deveficiente.casadocodigo.compartilhado.UniqueValue;

public class NovoPaisRequest {
	@NotNull
	@NotBlank
	@UniqueValue(domainClass = Pais.class, fieldName = "nome")
	private String nome;

	
	/*
	 * O jackson não trabalha muito bem quando vai receber só um atributo via construtor, por isso tem que fazer esse set solitário
	 */
	public void setNome(@NotNull String nome) {
		this.nome = nome;
	}

	public Pais toModel() {
		return new Pais(nome);
	}

}
