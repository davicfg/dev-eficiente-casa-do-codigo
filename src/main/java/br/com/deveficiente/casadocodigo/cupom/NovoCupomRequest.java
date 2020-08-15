package br.com.deveficiente.casadocodigo.cupom;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;


import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.deveficiente.casadocodigo.compartilhado.ExistId;
import br.com.deveficiente.casadocodigo.compartilhado.UniqueValue;

public class NovoCupomRequest {
	@NotBlank
	@UniqueValue(domainClass = Cupom.class, fieldName = "codigo")
	private String codigo;
	@NotNull
	@Positive
	private BigDecimal desconto;
	@Future
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate validade;
	
	
	public NovoCupomRequest(@NotBlank String codigo, @NotNull @Positive BigDecimal desconto) {
		super();
		this.codigo = codigo;
		this.desconto = desconto;
	}
	
	
	public void setValidadade(@Future @NotNull LocalDate validade) {
		this.validade = validade;
	}

	public Cupom toModel() {
		return new Cupom(codigo, desconto, validade);
	}
	
}
