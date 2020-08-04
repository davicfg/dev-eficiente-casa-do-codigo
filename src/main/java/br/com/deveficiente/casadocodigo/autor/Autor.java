package br.com.deveficiente.casadocodigo.autor;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.util.Assert;

@Entity
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private @NotBlank String nome;
	private @NotBlank @Email  String email;
	private @NotBlank @Size(max = 400) String descricao;
	@Column(name = "criado_em")
	private LocalDateTime criadoEm = LocalDateTime.now();

	@Deprecated
	public Autor() {
		
	}
	public Autor(@NotBlank String nome, @NotBlank @Email String email, @NotBlank @Size(max = 400) String descricao) {
		Assert.hasLength(nome, "O nome é obrigatório");//programação defensiva
		
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	
	public String getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {
		return "Autor [nome=" + nome + ", email=" + email + ", descricao=" + descricao + ", criadoEm="
				+ criadoEm + "]";
	}

}
