package com.aprendendothymeleaf.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aprendendothymeleaf.domain.Cargo;
import com.aprendendothymeleaf.service.CargoService;
import com.aprendendothymeleaf.service.DepartamentoService;

@Controller
@RequestMapping("/cargos")
public class CargoController {
	
	@Autowired
	DepartamentoService depServico;
	
	@Autowired
	CargoService servico;
	
	//retorna a tela cadastro
	@GetMapping("/cadastrar")
	public String cadastrar(Cargo cargo, ModelMap model) {
		model.addAttribute("departamentos", depServico.bustarTodos());
		return"/cargo/cadastro";
	}
	//retorna a tela listar
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("cargos",servico.bustarTodos());
		return "/cargo/lista";
	}
	
	
	/*
	 * Como estou recebendo aapenas a id do departamento ocorre um erro
	 * eu criei um novo pacote de conversor com a intencao de converter
	 * a id em um objeto de departamento
	 */
	
	/*
	 * Na anotação @Valid é para informar ao spring que tem que ser feito uma validação
	 * Nos parametros do metodo salvar e editar e importante que o BindingResult venha antes
	 * do RedirectAttributes se nao ocorre erro.
	 */
	@PostMapping("/salvar")
	public String salvar(@Valid Cargo cargo, BindingResult result, RedirectAttributes obj) {
		if(result.hasErrors()) {
			return "/cargo/cadastro";
		}
		servico.salvar(cargo);
		obj.addFlashAttribute("success", "Cargo Inserido com sucesso");
		return "redirect:/cargos/cadastrar/";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Integer id, ModelMap model) {
		model.addAttribute("cargo", servico.buscarId(id));
		model.addAttribute("departamentos", depServico.bustarTodos());
		return "cargo/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Cargo cargo,BindingResult result, RedirectAttributes obj) {
		if(result.hasErrors()) {
			return "/cargo/cadastro";
		}
		servico.atualizar(cargo);
		obj.addFlashAttribute("success", "Cargo editado com sucesso!");
		return "redirect:/cargos/listar";
	}
	
	@GetMapping("/deletar/{id}")
	public String deletar(@PathVariable("id") Integer id, ModelMap model) {
		if(!servico.temFuncionario(id)) {
			model.addAttribute("fail","Não é possivel remover o cargo");
		}
		else {
			servico.deletar(id);
			model.addAttribute("success","Cargo deletado com sucesso");
		}
		return "redirect:/cargos/listar";
	}
}
