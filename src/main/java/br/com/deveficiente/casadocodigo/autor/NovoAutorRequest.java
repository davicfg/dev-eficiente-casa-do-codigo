package br.com.deveficiente.casadocodigo.autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.deveficiente.casadocodigo.compartilhado.UniqueValue;

public class NovoAutorRequest {
	
	@NotBlank
	private String nome;
	@NotBlank
	@Email
	@UniqueValue(domainClass = Autor.class, fieldName = "email")
	private String email;
	@NotBlank
	@Size(max=400)
	private String descricao;
	
	public NovoAutorRequest(@NotBlank String nome, @NotBlank @Email String email,
			@NotBlank @Size(max = 400) String descricao) {
		
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public Autor toModel() {
		//Se a informação é obrigáoria tem que constar no construtor da entidade/classe
		return new Autor(this.nome, this.email, this.descricao);
	}

	public String getEmail() {
		return this.email;
	}
	
	
	
}
