package com.demo.enums;

public enum PerfilEnum {
	
	ROLE_ADMIN("ROLE_ADMIN",1),
	ROLE_USUARIO("ROLE_USUARIO",2);

	private int codigo;
	private String descricao;

	private PerfilEnum(String descricao, int codigo) {
		this.setDescricao(descricao);
		this.setCodigo(codigo);
	}
	
	public static PerfilEnum getByCodigo(int cod) {
		if(cod < 1 || cod > 2) {
			return null;
		}
		for(PerfilEnum perfil : PerfilEnum.values()) {
			if(perfil.getCodigo() == cod)
				return perfil;
		}
			
		return null;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
