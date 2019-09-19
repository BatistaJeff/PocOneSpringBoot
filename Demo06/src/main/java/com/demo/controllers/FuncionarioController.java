package com.demo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dtos.FuncionarioDTO;
import com.demo.entity.Funcionario;
import com.demo.responses.Response;
import com.demo.services.FuncionarioService;

@RestController
@RequestMapping(path = "/api/funcionario")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService service; 


	@PostMapping
	public ResponseEntity<Response<FuncionarioDTO>> cadastrar(@Valid @RequestBody FuncionarioDTO funcionarioDTO, BindingResult result) {
		
		Response<FuncionarioDTO> response = new Response<FuncionarioDTO>();
		Funcionario funcionario = null;
		
		if(result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		} else {
			try {
				funcionario = this.service.cadastrarDTO(funcionarioDTO);
			} catch (Exception e) {
				response.getErrors().add(e.getMessage().toString());
			}
		}
		response.setData(funcionarioDTO);
		
		return ResponseEntity.ok(response);
	}
	
	
	
}