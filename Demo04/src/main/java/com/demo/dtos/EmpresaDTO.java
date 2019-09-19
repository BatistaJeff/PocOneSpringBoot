package com.demo.dtos;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;

public class EmpresaDTO {
	
	@NotEmpty(message = "Razão Social não pode ser vazia")
	@Length(min = 5, max = 200, message = "Razão Social deve conter entre 5 e 200 caracteres.")
	private String razaoSocial;
	
	@NotEmpty(message = "CNPJ não pode ser vazia")
	@CNPJ(message = "CNPJ inválido")
	private String cnpj;
	
	public EmpresaDTO() { }
	
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public String toString() {
		return "EmpresaDTO [razaoSocial=" + razaoSocial + ", cnpj=" + cnpj + "]";
	}
	
}
