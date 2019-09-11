package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Empresa;
import com.example.demo.repositories.EmpresaRepository;

@SpringBootApplication
public class Demo02Application {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Demo02Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			Empresa empresa = new Empresa();
			empresa.setCnpj("21212121212");
			empresa.setRazaoSocial("J B Magalhaes tecnologia");

			this.empresaRepository.save(empresa);
			
			List<Empresa> findAll = this.empresaRepository.findAll();
			
			findAll.forEach(System.out::println);
			
			Empresa findByCnpj = this.empresaRepository.findByCnpj("21212121212");
			
			System.out.println(findByCnpj.getCnpj());
			
			this.empresaRepository.delete(empresa);
			List<Empresa> findAll2 = this.empresaRepository.findAll();
			System.out.println("Tamanho da lista : " + findAll2.size());
		};
	}
	
}
 