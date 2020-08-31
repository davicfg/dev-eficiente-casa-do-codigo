package br.com.deveficiente.casadocodigo.fechamentocompra;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.deveficiente.casadocodigo.cupom.Cupom;

@Component
public class CupomValidoValidator implements Validator{
	
	@Autowired
	private CupomRepository repository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return NovaCompraRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		
		NovaCompraRequest request = (NovaCompraRequest) target;
		Optional<String> possivelCodigo = request.getCodigoCupom();
		if(possivelCodigo.isPresent()) {
			Cupom cupom = repository.getByCodigo(request.getCodigoCupom().get());
			if(!cupom.valido()) {
				errors.rejectValue("codigoCupom", null, "Este cupom não é mais valido");
			}
		}
	}

}
