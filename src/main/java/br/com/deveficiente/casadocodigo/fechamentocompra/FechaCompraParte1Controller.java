package br.com.deveficiente.casadocodigo.fechamentocompra;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
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
	private CupomRepository cupomRepository;
	
	@Autowired
	private EstadoPertenceAPaisValidator estadoPertenceAPaisValidator;

	@Autowired
	private EstadoEhHobrigatorioSePaisTemEstadoValidator estadoEhHobrigatorioSePaisTemEstadoValidator;
	
	@Autowired
	private CupomValidoValidator cupomValidoValidator;
	@PersistenceContext
	private EntityManager manager;


	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(new VerificaDocumentoCpfCnpjValidator(), estadoPertenceAPaisValidator, estadoEhHobrigatorioSePaisTemEstadoValidator, cupomValidoValidator);
	}
	
	@PostMapping(value = "/fechamento-compra")
	@Transactional
	public String novaCompra(@RequestBody @Valid NovaCompraRequest request) {
		Compra novaCompra = request.toModel(manager, cupomRepository);
		manager.persist(novaCompra);
		return novaCompra.toString();
	}

}
