package br.com.deveficiente.casadocodigo.livro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.sun.istack.NotNull;

import br.com.deveficiente.casadocodigo.autor.Autor;
import br.com.deveficiente.casadocodigo.categoria.Categoria;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private @NotBlank String titulo;
	private @NotBlank @Length(max = 500) String resumo;
	private String sumario;
	private @Min(20) BigDecimal preco;

	@Column(name = "numero_paginas")
	private @Min(100) int numeroPaginas;
	private @NotBlank String isbn;

	@Column(name = "data_lancamento")
	private @Future LocalDate dataLancamento;

	@ManyToOne
	private @NotNull Categoria categoria;
	
	@ManyToOne
	private @NotNull Autor autor;
	
	@Deprecated
	public Livro() {
		
	}

	public Livro(@NotBlank String titulo, @NotBlank @Length(max = 500) String resumo, String sumario,
			@Min(20) BigDecimal preco, @Min(100) int numeroPaginas, @NotBlank String isbn,
			@Future LocalDate dataLancamento, Autor autor, Categoria categoria) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.dataLancamento = dataLancamento;
		this.categoria = categoria;
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "Livro [titulo=" + titulo + ", resumo=" + resumo + ", sumario=" + sumario + ", preco=" + preco
				+ ", numeroPaginas=" + numeroPaginas + ", isbn=" + isbn + ", dataLancamento=" + dataLancamento
				+ ", categoria=" + categoria.toString() + ", autor=" + autor.toString() + "]";
	}

}
