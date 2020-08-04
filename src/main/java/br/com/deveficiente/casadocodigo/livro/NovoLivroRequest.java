package br.com.deveficiente.casadocodigo.livro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

import br.com.deveficiente.casadocodigo.autor.Autor;
import br.com.deveficiente.casadocodigo.categoria.Categoria;
import br.com.deveficiente.casadocodigo.compartilhado.ExistId;
import br.com.deveficiente.casadocodigo.compartilhado.UniqueValue;

public class NovoLivroRequest {

	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "titulo")
	private String titulo;
	@NotBlank
	@Size(max = 500)
	private String resumo;
	@NotBlank
	private String sumario;
	@NotNull
	@Min(value = 20)
	private BigDecimal preco;
	@Min(value = 100)
	private int numeroPaginas;
	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "isbn")
	private String isbn;
	@Future
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dataLancamento;
	@NotNull
	@ExistId(domainClass = Categoria.class, fieldName = "id")
	private Long idCategoria;
	@NotNull
	@ExistId(domainClass = Autor.class, fieldName = "id")
	private Long idAutor;

	public NovoLivroRequest(@NotBlank String titulo, @NotBlank @Length(max = 500) String resumo, String sumario,
			@Min(20) BigDecimal preco, @Min(100) int numeroPaginas, @NotBlank String isbn, Long idCategoria, Long idAutor) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.idCategoria = idCategoria;
		this.idAutor = idAutor;
	}
	
	/*
	 * Existe esse único set porque, aparentemente, o Jackson não consegue desserializar o json com uma data no parâmetro via construtor
	 * Talvez existe alguma forma melhorde de fazer
	 */
	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Livro toModel(EntityManager manager) {
		@NotNull Autor autor = manager.find(Autor.class, idAutor);
		@NotNull Categoria categoria = manager.find(Categoria.class, idCategoria);
		
		Assert.state(autor!=null, "Não existe o autor para o id: "+idAutor);
		Assert.state(categoria!=null, "Não existe a categoria para o id: "+idCategoria);
		
		return new Livro(titulo, resumo, sumario, preco, numeroPaginas, isbn, dataLancamento, autor, categoria);
	}
}

