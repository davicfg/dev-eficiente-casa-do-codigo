package br.com.deveficiente.casadocodigo.fechamentocompra;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.util.Assert;

import br.com.deveficiente.casadocodigo.compartilhado.ExistId;
import br.com.deveficiente.casadocodigo.estado.Estado;
import br.com.deveficiente.casadocodigo.pais.Pais;

public class NovaCompraRequest {
	@NotBlank
	@Email
	private String email;
	@NotBlank
	private String nome;
	@NotBlank
	private String sobrenome;
	@NotBlank
	private String documento;
	@NotBlank
	private String endereco;
	@NotBlank
	private String complemento;
	@NotBlank
	private String cidade;
	@NotNull
	@ExistId(domainClass = Pais.class, fieldName = "id")
	private Long idPais;
	@ExistId(domainClass = Estado.class, fieldName = "id")
	// Validar se um pais tem estado cadastrado
	private Long idEstado;
	@NotBlank
	private String telefone;
	@NotBlank
	private String cep;
	@Valid
	@NotNull
	private NovoPedidoRequest pedido;

	public NovaCompraRequest(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotNull Long idPais, Long idEstado, @NotBlank String telefone,
			@NotBlank String cep, @Valid @NotNull NovoPedidoRequest pedido) {
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.idPais = idPais;
		this.idEstado = idEstado;
		this.telefone = telefone;
		this.cep = cep;
		this.pedido = pedido;

	}

	/*
	 * Esse método ficou pq aqui juntamos comportamento com estado e isso é muito
	 * bom para coesão. Eu bem que poderia ter feito isso no
	 * VerificaDocumentoCpfCnpjValidator, mas ia manipular meu estado fora da classe
	 * dele.
	 */
	public boolean documentoValido() {
		Assert.hasLength(documento, "você não deveria validar o documento se ele não tiver sido preenchido");

		/*
		 * Outro abordagem seria copiar as classes de validação do cpf e do cnpj para
		 * não ficar acoplado com o hibernate
		 */
		CPFValidator cpfValidator = new CPFValidator();
		cpfValidator.initialize(null);

		CNPJValidator cnpjValidator = new CNPJValidator();
		cnpjValidator.initialize(null);

		return cpfValidator.isValid(documento, null) || cnpjValidator.isValid(documento, null);
	}

	@Override
	public String toString() {
		return "NovaCompraRequest [email=" + email + ", nome=" + nome + ", sobrenome=" + sobrenome + ", documento="
				+ documento + ", endereco=" + endereco + ", complemento=" + complemento + ", cidade=" + cidade
				+ ", idPais=" + idPais + ", idEstado=" + idEstado + ", telefone=" + telefone + ", cep=" + cep + "]";
	}

	public Long getIdPais() {
		return idPais;
	}

	public Long getIdEstado() {
		return idEstado;
	}

}
