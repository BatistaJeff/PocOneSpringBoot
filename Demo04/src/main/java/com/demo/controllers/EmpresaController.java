package com.demo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dtos.EmpresaDTO;
import com.demo.entity.Empresa;
import com.demo.responses.Response;
import com.demo.services.EmpresaService;

@RestController
@RequestMapping(path = "/api/empresa")
public class EmpresaController {

	@Autowired
	private EmpresaService service;
	Empresa empresa = null;
	
	@PostMapping 
	public ResponseEntity<Response<EmpresaDTO>> cadastrar(@Valid @RequestBody EmpresaDTO empresaDTO, BindingResult result) {
		
		Response<EmpresaDTO> response = new Response<EmpresaDTO>();
		
		if(result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		} else {
			try {
				Empresa empresa = this.service.cadastrarDTO(empresaDTO);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		response.setData(empresaDTO);

		return ResponseEntity.ok(response);
	}
}
