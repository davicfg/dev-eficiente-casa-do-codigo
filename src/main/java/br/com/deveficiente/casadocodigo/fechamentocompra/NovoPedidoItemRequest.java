package br.com.deveficiente.casadocodigo.fechamentocompra;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

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
	
	public Long getIdLivro() {
		return idLivro;
	}

	public ItemPedido toModel(EntityManager manager) {
		@NotNull Livro livro = manager.find(Livro.class, idLivro);
		return new ItemPedido(livro, quantidade);
	}
	

}
