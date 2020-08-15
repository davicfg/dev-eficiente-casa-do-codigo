package br.com.deveficiente.casadocodigo.Post;

import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;

public class AgendamentoPost {

	private @NotBlank String nomeAutor;
	private @NotBlank String titulo;
	private @NotBlank String texto;
	private @FutureOrPresent LocalDate dataPostagem;
	private String tags;

	public AgendamentoPost(@NotBlank String nomeAutor, @NotBlank String titulo, @NotBlank String texto,
			@FutureOrPresent LocalDate dataPostagem, String tags) {
		this.nomeAutor = nomeAutor;
		this.titulo = titulo;
		this.texto = texto;
		this.dataPostagem = dataPostagem;
		this.tags = tags;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getTexto() {
		return texto;
	}

	public LocalDate getDataPostagem() {
		return dataPostagem;
	}

	public String getTags() {
		return tags;
	}

}
