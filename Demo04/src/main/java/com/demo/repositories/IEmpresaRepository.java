package com.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.entity.Empresa;

public interface IEmpresaRepository extends JpaRepository<Empresa, Long> {

	public Empresa findByCnpj(String cnpjEmpresa);

}
