package com.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.entity.Funcionario;

public interface IFuncionarioRepository extends JpaRepository<Funcionario, Long>{

	public Funcionario findOneByCpf(String cpf);
	
	
}
