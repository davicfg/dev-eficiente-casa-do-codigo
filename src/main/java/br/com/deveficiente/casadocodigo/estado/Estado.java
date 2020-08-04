package br.com.deveficiente.casadocodigo.estado;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.deveficiente.casadocodigo.Pais.Pais;

@Entity
public class Estado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private @NotNull @NotBlank String nome;
	
	@ManyToOne
	private Pais pais;
	
	
	public Estado(@NotNull @NotBlank String nome, Pais pais) {
		this.nome = nome;
		this.pais = pais;
	}

}
