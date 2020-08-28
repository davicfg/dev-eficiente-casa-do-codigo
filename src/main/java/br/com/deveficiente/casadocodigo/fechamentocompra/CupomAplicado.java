package br.com.deveficiente.casadocodigo.fechamentocompra;

import java.math.BigDecimal;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import br.com.deveficiente.casadocodigo.cupom.Cupom;

@Embeddable
public class CupomAplicado {

	@ManyToOne
	private Cupom cupom;
	private BigDecimal percentualDescontoMomento;
	private Object validadeMomento;

	public CupomAplicado(Cupom cupom) {
		this.cupom = cupom;
		this.percentualDescontoMomento = cupom.getPercentualdesconto();
		this.validadeMomento = cupom.getValidade();
		
	}
	
	
}
