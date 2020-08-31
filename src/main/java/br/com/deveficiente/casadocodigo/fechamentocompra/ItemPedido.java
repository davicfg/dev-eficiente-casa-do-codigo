package br.com.deveficiente.casadocodigo.fechamentocompra;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.deveficiente.casadocodigo.livro.Livro;

@Entity
public class ItemPedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private @NotNull Livro livro;
	private @Positive int quantidade;
	private @Positive BigDecimal precoMomento;

	public ItemPedido(@NotNull Livro livro, @Positive int quantidade) {
		
		this.livro = livro;
		this.quantidade = quantidade;
		this.precoMomento = livro.getPreco();
	}

	public BigDecimal total() {
		return precoMomento.multiply(new BigDecimal(quantidade));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((livro == null) ? 0 : livro.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		if (livro == null) {
			if (other.livro != null)
				return false;
		} else if (!livro.equals(other.livro))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ItemPedido [livro=" + livro + ", quantidade=" + quantidade + ", precoMomento=" + precoMomento + "]";
	}
}
