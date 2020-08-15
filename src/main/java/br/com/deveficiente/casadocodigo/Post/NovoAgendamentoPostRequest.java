package br.com.deveficiente.casadocodigo.Post;

import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

public class NovoAgendamentoPostRequest {
	@NotBlank
	private String nomeAutor;
	@NotBlank
	private String titulo;
	@NotBlank
	private String texto;
	@FutureOrPresent
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dataPostagem;
	private String tags;

	public NovoAgendamentoPostRequest(@NotEmpty @NotNull String nomeAutor, @NotEmpty String titulo, @NotEmpty String texto,
			String tags) {
		this.nomeAutor = nomeAutor;
		this.titulo = titulo;
		this.texto = texto;
		this.tags = tags;
	}

	/*
	 * Esse set está aqui porque de alguma forma o Jackson não consegue deseralizar
	 * pelo construtor um atributo do tipo java.time.LocalDate. Talvez tenha alguma forma melhor de fazer isso
	 */
	public void setDataPostagem(@FutureOrPresent LocalDate dataPostagem) {
		this.dataPostagem = dataPostagem;
	}

	@Override
	public String toString() {
		return "NovoAgendamentoRequest [nomeAutor=" + nomeAutor + ", titulo=" + titulo + ", texto=" + texto
				+ ", dataPostagem=" + dataPostagem + ", tags=" + tags + "]";
	}

	public AgendamentoPost toModel() {
			
		return new AgendamentoPost(nomeAutor, titulo, texto, dataPostagem, tags);
	}
}
