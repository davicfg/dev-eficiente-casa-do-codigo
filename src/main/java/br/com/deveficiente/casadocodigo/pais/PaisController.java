package br.com.deveficiente.casadocodigo.pais;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaisController {
	
	@PersistenceContext
	EntityManager manager;
	
	@PostMapping("/pais")
	@Transactional
	public String criarPais(@RequestBody @Valid NovoPaisRequest request) {
		Pais novoPais = request.toModel();
		manager.persist(novoPais);
		return novoPais.toString();
	}
}
