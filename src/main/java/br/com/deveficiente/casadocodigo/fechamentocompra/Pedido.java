package br.com.deveficiente.casadocodigo.fechamentocompra;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.util.Assert;

public class Pedido {

	private @NotNull @Valid Compra compra;
	private @Size(min = 1) Set<ItemPedido> itens = new HashSet<>();

	public Pedido(@NotNull @Valid Compra compra, @Size(min = 1) Set<ItemPedido> itens) {
		Assert.isTrue(!itens.isEmpty(), "todo pedido deve ter pelo menos um item");
		this.compra = compra;
		this.itens.addAll(itens);

	}
	

	@Override
	public String toString() {
		return "Pedido [compra=" + compra + ", itens=" + itens.toString() + "]";
	}


	public boolean totalIgual(@Positive BigDecimal total) {
		BigDecimal totalPedido = itens.stream().map(ItemPedido:: total).reduce(BigDecimal.ZERO, (atual, proximo) -> atual.add(proximo));
		return totalPedido.doubleValue() == total.doubleValue();
	}

}
