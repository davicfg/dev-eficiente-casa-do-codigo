package br.com.deveficiente.casadocodigo.fechamentocompra;

import javax.validation.constraints.Positive;

import com.sun.istack.NotNull;

import br.com.deveficiente.casadocodigo.compartilhado.ExistId;
import br.com.deveficiente.casadocodigo.livro.Livro;

public class NovoPedidoItemRequest {

	@NotNull
	@ExistId(domainClass = Livro.class, fieldName = "id")
	private Long idLivro;
	@Positive
	private int quantidade;

	public NovoPedidoItemRequest(Long idLivro, @Positive int quantidade) {
		this.idLivro = idLivro;
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "NovoPedidoItemRequest [idLivro=" + idLivro + ", quantidade=" + quantidade + "]";
	}

}
