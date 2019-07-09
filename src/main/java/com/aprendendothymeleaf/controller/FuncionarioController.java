package com.aprendendothymeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aprendendothymeleaf.domain.Cargo;
import com.aprendendothymeleaf.domain.Funcionario;
import com.aprendendothymeleaf.domain.UF;
import com.aprendendothymeleaf.service.CargoService;
import com.aprendendothymeleaf.service.FuncionarioService;


@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	@Autowired
	private CargoService cargoServico;
	
	@Autowired
	private FuncionarioService funcServico;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Funcionario funcionario) {
		return "/funcionario/cadastro";
	}
	
	@PostMapping("/salvar")
	public String salvar(Funcionario funcionario) {
		funcServico.salvar(funcionario);
		return "redirect:/funcionarios/cadastrar";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("funcionario", funcServico.bustarTodos());
		return "/funcionario/lista";
	}
	
	@ModelAttribute("cargos")
	public List<Cargo> getCargos(){
		return cargoServico.bustarTodos();
	}
	
	@ModelAttribute("ufs")
	public UF[] getUFs() {
		return UF.values();
	}
}
