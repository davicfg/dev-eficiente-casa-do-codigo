package br.com.deveficiente.casadocodigo.cupom;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
public class Cupom {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private @NotBlank String codigo;
	@Column(name = "percentual_desconto")
	private @NotNull @Positive BigDecimal percentualDesconto;
	private @Future @NotNull LocalDate validade;

	public Cupom(@NotBlank String codigo, @NotNull @Positive BigDecimal codigoCupom, @NotNull @Future LocalDate validade) {
		this.codigo = codigo;
		this.percentualDesconto = codigoCupom;
		this.validade = validade;
	}

	@Override
	public String toString() {
		return "Cupom [id=" + id + ", codigo=" + codigo + ", desconto=" + percentualDesconto + ", validadade=" + validade + "]";
	}

	public boolean valido() {
		return LocalDate.now().compareTo(this.validade) <=0;
	}

	public BigDecimal getPercentualdesconto() {
		return percentualDesconto;
	}

	public Object getValidade() {
		return validade;
	}
	
}
