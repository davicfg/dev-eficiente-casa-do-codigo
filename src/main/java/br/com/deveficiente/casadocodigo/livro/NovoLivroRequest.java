package br.com.deveficiente.casadocodigo.livro;

import java.time.LocalDateTime;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.sun.istack.NotNull;

import br.com.deveficiente.casadocodigo.compartilhado.UniqueValue;

public class NovoLivroRequest {

	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "titulo")
	private String titulo;
	@NotBlank
	@Length(max = 500)
	private String resumo;
	private String sumario;
	@Min(value = 20)
	private Double preco;
	@Min(value=100)
	private int numeroPaginas;
	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "isbn")
	private String isbn;
	@Future
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", shape=Shape.STRING)
	private LocalDateTime dataLancamento;
	@NotNull
	private Long idCategoria;
	@NotNull
	private Long idAutor;
	public NovoLivroRequest(@NotBlank String titulo, @NotBlank @Length(max = 500) String resumo, String sumario,
			@Min(20) Double preco, @Min(100) int numeroPaginas, @NotBlank String isbn,
			@Future LocalDateTime dataLancamento, Long idCategoria, Long idAutor) {
		super();
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
	public Livro toModel() {
		return new Livro(titulo, resumo, sumario, preco, numeroPaginas, isbn, dataLancamento, idCategoria, idAutor);
	}
}
