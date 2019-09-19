package com.demo.services.interfaces;

import java.util.Optional;

import com.demo.entity.Funcionario;

public interface IFuncionarioService {
	/**
	 * Busca e retorna um usuário dado um email
	 * @param email
	 * @return
	 */
	Optional<Funcionario> buscarPorEmail(String email);
}
