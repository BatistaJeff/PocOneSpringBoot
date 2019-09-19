package com.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.Lancamento;

public interface ILancamentoRepository extends JpaRepository<Lancamento, Long> {

	
}
