package com.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.demo.entity.Funcionario;
import com.demo.enums.PerfilEnum;
import com.demo.services.FuncionarioService;
import com.demo.utils.SenhaUtils;

@SpringBootApplication
public class Demo06Application {

	@Autowired
	private FuncionarioService service;
	
	public static void main(String[] args) {
		SpringApplication.run(Demo06Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			Funcionario funcionario = new Funcionario();
			funcionario.setCpf("138.450.200-91");
			funcionario.setEmail("bruce@wayne.com");
			funcionario.setNome("bruce wayne");
			funcionario.setPerfil(PerfilEnum.ROLE_ADMIN);
			funcionario.setQtdHrAlmoco(1.22F);
			funcionario.setQtdHrTrabalhoDia(2.22F);
			funcionario.setSenha(SenhaUtils.gerarBCrypt("123456"));
			funcionario.setValorHora(new BigDecimal("12"));
			System.out.println("TESTE 1 2 3 4 5");
			System.out.println("TESTE 1 2 3 4 5");
			System.out.println("TESTE 1 2 3 4 5");
			this.service.cadastrar(funcionario);
			
		};
	}
	
}
