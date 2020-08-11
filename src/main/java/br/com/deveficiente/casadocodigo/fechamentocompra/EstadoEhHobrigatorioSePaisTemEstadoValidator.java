package br.com.deveficiente.casadocodigo.fechamentocompra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class EstadoEhHobrigatorioSePaisTemEstadoValidator implements Validator {
	@PersistenceContext
	private EntityManager manager;

	@Override
	public boolean supports(Class<?> clazz) {
		return NovaCompraRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}
		NovaCompraRequest request = (NovaCompraRequest) target;

		Query query = manager.createQuery("select 1 from Estado where pais_id = :idPais");
		System.out.println(request.getIdPais()+" id do pais");
		query.setParameter("idPais", request.getIdPais());
		List<?> possivelEstado = query.getResultList();

		if (possivelEstado.isEmpty()) {
			errors.rejectValue("idEstado", null, "O país tem um estado e o campo estado não foi preechido");
		}
	}

}
