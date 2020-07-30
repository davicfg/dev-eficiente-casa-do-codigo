package br.com.deveficiente.casadocodigo.categoria;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProibeNomeDuplicadoCategoriaValidator implements Validator{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return NovaCategoriaRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		
		NovaCategoriaRequest request = (NovaCategoriaRequest) target;
		
		Optional<Categoria> possivelCategoria = categoriaRepository.findByNome(request.getNome());
		
		if(possivelCategoria.isPresent()) { 
			errors.rejectValue("Nome", null, "O nome da categoria já está em uso");
		}
	}
	
}
