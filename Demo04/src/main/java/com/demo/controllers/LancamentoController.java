package com.demo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dtos.LancamentoDTO;
import com.demo.entity.Lancamento;
import com.demo.responses.Response;
import com.demo.services.LancamentoService;

@RestController
@RequestMapping(path = "/api/lancamento")
public class LancamentoController {
	
	@Autowired
	private LancamentoService lancamentoService;

	@PostMapping
	public ResponseEntity<Response<LancamentoDTO>> cadastrar(@Valid @RequestBody LancamentoDTO lancamentoDTO, BindingResult result) {

		Response<LancamentoDTO> response = new Response<LancamentoDTO>();
		
		if(result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		} else {
			try {
				Lancamento cadastrarDTO = lancamentoService.cadastrarDTO(lancamentoDTO);
			} catch (Exception e) {
				response.getErrors().add(e.getMessage().toString());
			}
		}
		response.setData(lancamentoDTO);
		
		return ResponseEntity.ok(response);
	}
	
	
	
	
}
