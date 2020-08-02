package br.com.deveficiente.casadocodigo.livro;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private @NotBlank String titulo;
	private @NotBlank @Length(max = 500) String resumo;
	private String sumario;
	private @Min(20) Double preco;

	@Column(name = "numero_paginas")
	private @Min(100) int numeroPaginas;
	private @NotBlank String isbn;

	@Column(name = "data_lancamento")
	private @Future LocalDateTime dataLancamento;

	@Column(name = "id_categoria")

	private Long idCategoria;

	@Column(name = "id_autor")
	private Long idAutor;
	
	@Deprecated
	public Livro() {
		
	}

	public Livro(@NotBlank String titulo, @NotBlank @Length(max = 500) String resumo, String sumario,
			@Min(20) Double preco, @Min(100) int numeroPaginas, @NotBlank String isbn,
			@Future LocalDateTime dataLancamento, Long idCategoria, Long idAutor) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.dataLancamento = dataLancamento;
		this.idCategoria = idCategoria;
		this.idAutor = idAutor;
	}

	@Override
	public String toString() {
		return "Livro [titulo=" + titulo + ", resumo=" + resumo + ", sumario=" + sumario + ", preco=" + preco
				+ ", numeroPaginas=" + numeroPaginas + ", isbn=" + isbn + ", dataLancamento=" + dataLancamento
				+ ", idCategoria=" + idCategoria + ", idAutor=" + idAutor + "]";
	}

}
