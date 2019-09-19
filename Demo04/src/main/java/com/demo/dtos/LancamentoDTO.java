package com.demo.dtos;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;

public class LancamentoDTO {

	@NotEmpty(message = "data não pode ser vazia")
	private String data;
	
	@NotEmpty(message = "descricao não pode ser vazia")
	private String descricao;
	
	@NotEmpty(message = "localização não pode ser vazia")
	private String localizacao;
	
	@NotEmpty(message = "tipo não pode ser vazia")
	private String tipo;
	
	@CPF
	@NotEmpty(message = "funcionario não pode ser vazia")
	private String cpfFuncionario;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCpfFuncionario() {
		return cpfFuncionario;
	}

	public void setCpfFuncionario(String cpfFuncionario) {
		this.cpfFuncionario = cpfFuncionario;
	}

	
}
