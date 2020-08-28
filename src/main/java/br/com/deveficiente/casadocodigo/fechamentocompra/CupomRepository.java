package br.com.deveficiente.casadocodigo.fechamentocompra;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.deveficiente.casadocodigo.cupom.Cupom;

@Repository
public interface CupomRepository extends CrudRepository<Cupom, Long>{
	
	/*
	 * Busca por um cupom que existe no sistema
	 */
	public Cupom getByCodigo(String codigo);
}
