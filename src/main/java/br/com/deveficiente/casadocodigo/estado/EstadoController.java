package br.com.deveficiente.casadocodigo.estado;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EstadoController {

	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping(value = "/estado")
	@Transactional
	public String criarEstado(@RequestBody @Valid NovoEstadoRequest request) {
		Estado novoEstado = request.toModel(manager);
		manager.persist(novoEstado);
		return "criando estado...";
	}

}
