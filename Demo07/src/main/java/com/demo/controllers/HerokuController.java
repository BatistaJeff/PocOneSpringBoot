package com.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/exemplo")
public class HerokuController {

	@GetMapping(value = "/{nome}")
	public String exemplo(@PathVariable("nome") String nome) {
		return "Olá " + nome;
	}
}
