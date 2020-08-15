package br.com.deveficiente.casadocodigo.cupom;

import java.math.BigDecimal;
import java.time.LocalDate;

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
	private @NotNull @Positive BigDecimal desconto;
	private @Future @NotNull LocalDate validade;

	public Cupom(@NotBlank String codigo, @NotNull @Positive BigDecimal desconto, @NotNull @Future LocalDate validade) {
		this.codigo = codigo;
		this.desconto = desconto;
		this.validade = validade;
	}

	@Override
	public String toString() {
		return "Cupom [id=" + id + ", codigo=" + codigo + ", desconto=" + desconto + ", validadade=" + validade + "]";
	}
	
}
