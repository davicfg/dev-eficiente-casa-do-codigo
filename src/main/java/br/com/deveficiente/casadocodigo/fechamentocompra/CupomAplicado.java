package br.com.deveficiente.casadocodigo.fechamentocompra;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.deveficiente.casadocodigo.cupom.Cupom;

@Embeddable
public class CupomAplicado {

	@ManyToOne
	private Cupom cupom;
	@Positive
	private BigDecimal percentualDescontoMomento;
	@NotNull
	@Future
	private LocalDate validadeMomento;
	
	@Deprecated
	public CupomAplicado() {
		super();
	}

	public CupomAplicado(Cupom cupom) {
		this.cupom = cupom;
		this.percentualDescontoMomento = cupom.getPercentualdesconto();
		this.validadeMomento = cupom.getValidade();
	}

	@Override
	public String toString() {
		return "CupomAplicado [cupom=" + cupom + ", percentualDescontoMomento=" + percentualDescontoMomento
				+ ", validadeMomento=" + validadeMomento + "]";
	}
	
	
}
