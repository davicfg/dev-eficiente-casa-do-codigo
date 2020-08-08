package br.com.deveficiente.casadocodigo.fechamentocompra;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

public class NovoPedidoRequest {

	@Positive
	@NotNull
	private BigDecimal total;
	@Size(min = 1)
	@Valid
	private List<NovoPedidoItemRequest> itens = new ArrayList<>();

	public NovoPedidoRequest(@Positive BigDecimal total, @Size(min = 1) @Valid List<NovoPedidoItemRequest> itens) {
		this.total = total;
		this.itens = itens;
	}

	@Override
	public String toString() {
		return "NovoPedidoRequest [total=" + total + ", itens=" + itens.toString() + "]";
	}
}
