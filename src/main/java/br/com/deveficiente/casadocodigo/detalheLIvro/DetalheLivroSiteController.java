package br.com.deveficiente.casadocodigo.detalheLIvro;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.deveficiente.casadocodigo.livro.Livro;

@RestController
public class DetalheLivroSiteController {

	@PersistenceContext
	private EntityManager manager;

	@GetMapping("/produto/{id}")
	public DetalheLivroSiteResponse detalheLivro(@PathVariable Long id) {
		Livro libroBuscado = manager.find(Livro.class, id);
		if(libroBuscado == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		DetalheLivroSiteResponse detalheLivroSiteResponse = new DetalheLivroSiteResponse(libroBuscado);
		return detalheLivroSiteResponse;
	}
}
