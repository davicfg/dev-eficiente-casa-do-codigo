package br.com.deveficiente.casadocodigo.livro;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LivroController {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Transactional
	@PostMapping("/livro")
	private String criar(@RequestBody @Valid NovoLivroRequest request) {
		Livro novoLivro = request.toModel();
		manager.persist(novoLivro);
		return novoLivro.toString();
	}
}