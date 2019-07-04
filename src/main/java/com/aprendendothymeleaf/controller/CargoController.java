package com.aprendendothymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cargos")
public class CargoController {
	
	//retorna a tela cadastro
	@GetMapping("/cadastrar")
	public String cadastrar() {
		return"/cargo/cadastro";
	}
	//retorna a tela listar
	@GetMapping("/listar")
	public String listar() {
		return "/cargo/lista";
	}
	
}
