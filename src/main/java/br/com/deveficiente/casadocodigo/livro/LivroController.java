package br.com.deveficiente.casadocodigo.livro;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LivroController {

	@PersistenceContext
	private EntityManager manager;

	@Autowired
	private LivroRepository livroRepository;

	/*
	 * Usei o EntityManager e o repository, por que não consegui usar o manager pra
	 * salvar, mesmo colocando o @Transactional.
	 */
	@PostMapping("/livro")
	public String criar(@RequestBody @Valid NovoLivroRequest request) {
		Livro novoLivro = request.toModel(manager);
		livroRepository.save(novoLivro);
		return novoLivro.toString();
	}

	@GetMapping("/livro")
	public List<LivroDTO> listarTodos() {
		Iterable<Livro> livros = livroRepository.findAll();
		
		List<LivroDTO> livrosDto = new ArrayList<LivroDTO>();
		for (Livro livro : livros) {
			livrosDto.add(new LivroDTO(livro.getId(), livro.getTitulo()));
		}
		return livrosDto;
	}
	
}
