package br.com.deveficiente.casadocodigo.detalheLIvro;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.deveficiente.casadocodigo.livro.Livro;

@RestController
public class DetalheLivroSiteController {

	@PersistenceContext
	private EntityManager manager;

	@GetMapping("/produto/{id}")
	public ResponseEntity<?> detalheLivro(@PathVariable Long id) {
		Livro libroBuscado = manager.find(Livro.class, id);
		if(libroBuscado == null) {
			return ResponseEntity.notFound().build();
		}
		
		DetalheLivroSiteResponse detalheLivroSiteResponse = new DetalheLivroSiteResponse(libroBuscado);
		return ResponseEntity.ok(detalheLivroSiteResponse);
	}
}
