package com.demo.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;

public class FuncionarioDTO {
	
	@CPF
	@NotEmpty(message = "cpf não pode ser vazia")
	private String cpf;

	@Email
	@NotEmpty(message = "email não pode ser vazia")
	private String email;
	
	@NotEmpty(message = "nome não pode ser vazia")
	private String nome;
	
	@NotEmpty(message = "senha não pode ser vazia")
	private String senha;
	
	@NotEmpty(message = "valor hora não pode ser vazia")
	private String valorHora;
	
	@NotEmpty(message = "quantidade de horas trabalho dia não pode ser vazia")
	private String qtdHrTrabalhoDia;
	
	@NotEmpty(message = "quantidade de hora almoço não pode ser vazia")
	private String qtdHrAlmoco;
	
	@NotEmpty(message = "perfil não pode ser vazia")
	private String perfil;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getValorHora() {
		return valorHora;
	}

	public void setValorHora(String valorHora) {
		this.valorHora = valorHora;
	}

	public String getQtdHrTrabalhoDia() {
		return qtdHrTrabalhoDia;
	}

	public void setQtdHrTrabalhoDia(String qtdHrTrabalhoDia) {
		this.qtdHrTrabalhoDia = qtdHrTrabalhoDia;
	}

	public String getQtdHrAlmoco() {
		return qtdHrAlmoco;
	}

	public void setQtdHrAlmoco(String qtdHrAlmoco) {
		this.qtdHrAlmoco = qtdHrAlmoco;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	
}
