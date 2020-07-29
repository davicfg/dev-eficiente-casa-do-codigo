package br.com.deveficiente.casadocodigo.casadocodigo.autor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutorController {
	
	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping("/autor")
	@Transactional
	public String novoAutor(@RequestBody @Valid NovoAutorRequest request){
		Autor novoAutor = request.toModel(); 
		manager.persist(novoAutor);
		return novoAutor.toString();
	}
}
