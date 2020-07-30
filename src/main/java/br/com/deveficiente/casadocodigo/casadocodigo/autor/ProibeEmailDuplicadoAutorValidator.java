package br.com.deveficiente.casadocodigo.casadocodigo.autor;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProibeEmailDuplicadoAutorValidator implements Validator{
	
	@Autowired
	private AutorRepository autorRepository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return NovoAutorRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		
		NovoAutorRequest request = (NovoAutorRequest) target;
		
		Optional<Autor> possivelAutor = autorRepository.findByEmail(request.getEmail());
		
		if(possivelAutor.isPresent()) {
			//Não deveriamos alterar um objecto que não foi criado por nós, mas podemos alterar esse referência na borda mais externa
			//O Spring sabe que eu vou alterar o errors
			errors.rejectValue("email", null, "Já existe um(a) autor(a) com o mesmo email "+request.getEmail());
		}
	}

}
