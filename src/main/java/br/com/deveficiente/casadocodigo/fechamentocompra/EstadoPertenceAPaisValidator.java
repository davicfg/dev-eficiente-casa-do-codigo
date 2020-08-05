package br.com.deveficiente.casadocodigo.fechamentocompra;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.deveficiente.casadocodigo.pais.Pais;

public class EstadoPertenceAPaisValidator implements Validator {

	@PersistenceContext
	private EntityManager entityManager;
	
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
		System.out.println(request.getIdPais());
		System.out.println(Pais.class);
		System.out.println(entityManager.toString());
//		Pais pais = manager.find(Pais.class, request.getIdPais());
//		
//		Estado estado = manager.find(Estado.class, request.getIdEstado());
//		
//		if(!estado.pertenceAPais(pais)) {
//			errors.rejectValue("idEstado", null, "este estado não é do país selecionado");
//		}
	}

}
