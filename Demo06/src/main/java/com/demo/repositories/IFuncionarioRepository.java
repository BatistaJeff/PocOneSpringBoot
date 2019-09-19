package com.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.entity.Funcionario;

@Transactional
public interface IFuncionarioRepository extends JpaRepository<Funcionario, Long>{

	public Funcionario findOneByCpf(String cpf);
	
	public Funcionario findByEmail(String email);
	
}
