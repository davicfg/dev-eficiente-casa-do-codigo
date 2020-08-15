package br.com.deveficiente.casadocodigo.Post;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
	
	@PostMapping("/post")
	public AgendamentoPost criarAgendamento(@RequestBody @Valid NovoAgendamentoPostRequest request) {
		AgendamentoPost novoAgendamento = request.toModel();
		return novoAgendamento;
	}
}
