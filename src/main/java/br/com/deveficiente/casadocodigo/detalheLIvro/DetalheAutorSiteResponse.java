package br.com.deveficiente.casadocodigo.detalheLIvro;

import br.com.deveficiente.casadocodigo.autor.Autor;

public class DetalheAutorSiteResponse {

	private String nome;
	private String descricao;

	public DetalheAutorSiteResponse(Autor autor) {
		nome = autor.getNome();
		descricao = autor.getDescricao();
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}
}
