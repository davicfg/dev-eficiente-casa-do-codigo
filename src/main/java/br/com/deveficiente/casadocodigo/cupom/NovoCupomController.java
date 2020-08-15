package br.com.deveficiente.casadocodigo.cupom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NovoCupomController {
	
	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping("cupom")
	@Transactional
	public String cria(@Valid @RequestBody NovoCupomRequest request) {
		
		Cupom novoCupom = request.toModel();
		
		manager.persist(novoCupom);
		
		return novoCupom.toString();
	}
}
