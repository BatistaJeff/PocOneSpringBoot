package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.demo.utils.SenhaUtils;
import com.demo.utils.services.ExemploService;

@SpringBootApplication
public class Demo01Application {

	@Value("${paginacao.qtd_por_pagina}")
	private int qtdPorPagina; 
	
	@Autowired
	private ExemploService exemploService;
	
	public static void main(String[] args) {
		SpringApplication.run(Demo01Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			/* Usando o valor de leitura dos properties 
			 * 
			 */
			System.out.println("### Quantidade de elementos " + this.qtdPorPagina);
			
			/* Usando criptografia em senha
			 * 
			 */
			String senhaEncoded = SenhaUtils.geradorBCrypt("123456");
			System.out.println("Senha encoded --> " +senhaEncoded);
			
			senhaEncoded = SenhaUtils.geradorBCrypt("123456");
			System.out.println("Senha encoded novamente --> " +senhaEncoded);
			String flag = SenhaUtils.senhaValida("123456", senhaEncoded) == Boolean.TRUE ? "SIM" : "NÃO" ;
			System.out.println("Senha valida ? " + flag);
			
			/* Usando Service
			 * 
			 */
			this.exemploService.testaService();
			
		};
	}
	
}
