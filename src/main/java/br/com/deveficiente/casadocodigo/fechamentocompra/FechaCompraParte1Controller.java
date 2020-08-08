package br.com.deveficiente.casadocodigo.fechamentocompra;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FechaCompraParte1Controller {
	
	@Autowired
	private EstadoPertenceAPaisValidator estadoPertenceAPaisValidator;

	@Autowired
	private EstadoEhHobrigatorioSePaisTemEstadoValidator estadoEhHobrigatorioSePaisTemEstadoValidator;
	
	@PersistenceContext
	private EntityManager manager;


	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(new VerificaDocumentoCpfCnpjValidator(), estadoPertenceAPaisValidator, estadoEhHobrigatorioSePaisTemEstadoValidator);
	}
	
	@PostMapping(value = "/fechamento-compra")
	public String novaCompra(@RequestBody @Valid NovaCompraRequest request) {
		Compra novaCompra = request.toModel(manager);
		return novaCompra.toString();
	}

}
