package br.com.deveficiente.casadocodigo.fechamentocompra;

import java.util.function.Function;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.util.Assert;

import br.com.deveficiente.casadocodigo.cupom.Cupom;
import br.com.deveficiente.casadocodigo.estado.Estado;
import br.com.deveficiente.casadocodigo.pais.Pais;

@Entity
public class Compra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private @NotBlank @Email String email;
	private @NotBlank String nome;
	private @NotBlank String sobrenome;
	private @NotBlank String documento;
	private @NotBlank String endereco;
	private @NotBlank String complemento;
	@ManyToOne
	private @NotNull Pais pais;
	private @NotBlank String telefone;
	private @NotBlank String cep;

	@ManyToOne
	private Estado estado;
	@OneToOne(mappedBy = "compra", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
	private Pedido pedido;
	@Embedded
	private CupomAplicado cupomAplicado;

	public Compra(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento, @NotNull Pais pais,
			@NotBlank String telefone, @NotBlank String cep, Function<Compra, Pedido> funcaoCriacaoPedido) {
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.pais = pais;
		this.telefone = telefone;
		this.cep = cep;
		this.pedido = funcaoCriacaoPedido.apply(this);
	}

	public void setEstado(@NotNull @Valid Estado estado) {
		/*
		 * Sempre bom proteger a entrada dos dados nas nossas funções, pois não podemos
		 * depender que o usuário da nossa função seja bonzinho.
		 */
		Assert.notNull(pais, "Não vai dar certo associar essa compra com um estado nulo");
		Assert.isTrue(estado.pertenceAPais(pais), "Este estado não pertende ao país que foi associdado a compra");
		this.estado = estado;
	}

	public void aplicaCupom(Cupom cupom) {
		Assert.isTrue(cupom.valido(), "o Cupom usado não é mais valido");
		Assert.isNull(cupomAplicado, "você não pode trocar um cupo de uma compra");
		this.cupomAplicado = new CupomAplicado(cupom);

	}

	@Override
	public String toString() {
		return "Compra [email=" + email + ", nome=" + nome + ", sobrenome=" + sobrenome + ", documento=" + documento
				+ ", endereco=" + endereco + ", complemento=" + complemento + ", pais=" + pais + ", telefone="
				+ telefone + ", cep=" + cep + ", estado=" + estado + ", pedido=" + pedido + ", cupomAplicado="
				+ cupomAplicado + "]";
	}

}
