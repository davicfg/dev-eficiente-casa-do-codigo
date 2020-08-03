package br.com.deveficiente.casadocodigo.livro;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Transactional
public class LivroController {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private LivroRepository livroRepository;
	
	/*
	 * Usei o EntityManager e o repository, por que não consegui usar o manager pra salvar, mesmo colocando o @Transactional.
	 */
	@PostMapping("/livro")
	private String criar(@RequestBody @Valid NovoLivroRequest request) {
		Livro novoLivro = request.toModel(manager);
		livroRepository.save(novoLivro);
		return novoLivro.toString();
	}
}
