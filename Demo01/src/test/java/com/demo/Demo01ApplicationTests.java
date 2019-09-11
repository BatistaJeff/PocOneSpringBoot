package com.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest
class Demo01ApplicationTests {

	@Value("${paginacao.qtd_por_pagina}")
	private int qtdPorPagina;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCarregadorContextoDeTeste() {
		assertEquals(25, qtdPorPagina);
	}

}
