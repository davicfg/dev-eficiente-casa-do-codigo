package br.com.deveficiente.casadocodigo.detalheLIvro;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

import br.com.deveficiente.casadocodigo.livro.Livro;

public class DetalheLivroSiteResponse {

	private String titulo;
	private String isbn;
	private int numeroPaginas;
	private BigDecimal preco;
	private String resumo;
	private String sumario;
	private DetalheAutorSiteResponse autor;
	private String dataLancamento;

	public DetalheLivroSiteResponse(Livro livro) {
		titulo = livro.getTitulo();
		autor = new DetalheAutorSiteResponse(livro.getAutor());
		isbn = livro.getIsbn();
		numeroPaginas = livro.getNumeroPaginas();
		preco = livro.getPreco();
		resumo = livro.getResumo();
		sumario = livro.getSumario();
		dataLancamento = livro.getDataLancamento()
				.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

	public String getTitulo() {
		return titulo;
	}

	public DetalheAutorSiteResponse getAutor() {
		return autor;
	}

	public String getIsbn() {
		return isbn;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}
	
	public String getDataLancamento() {
		return dataLancamento;
	}
}
