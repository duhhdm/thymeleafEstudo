package com.aprendendothymeleaf.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Integer id, ModelMap model) {
		model.addAttribute("funcionario", funcServico.buscarId(id));
		return "/funcionario/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Funcionario funcionario, BindingResult result, RedirectAttributes obj) {
		if(result.hasErrors()) {
			return "/funcionario/cadastro";
		}
		funcServico.atualizar(funcionario);
		obj.addFlashAttribute("success","Funcionario editado com sucesso");
		return"redirect:/funcionarios/listar";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Funcionario funcionario, BindingResult result, RedirectAttributes obj) {
		if(result.hasErrors()) {
			return "/funcionario/cadastro";
		}
		funcServico.salvar(funcionario);
		obj.addFlashAttribute("success","Funcionario inserido com sucesso");
		return "redirect:/funcionarios/cadastrar";
	}
	
	@GetMapping("/buscar/nome")
	public String busrcaPorNome(@RequestParam("nome") String nome, ModelMap model) {
		model.addAttribute("funcionario", funcServico.buscarPorNome(nome));
		return "funcionario/lista";
	}
	
	@GetMapping("/buscar/cargo")
	public String buscarPorCargo(@RequestParam("cargo") Integer cargo, ModelMap model) {
		model.addAttribute("funcionario", funcServico.buscarPorCargo(cargo));
		return "/funcionario/lista";
	}
	
	@GetMapping("/buscar/data")
	public String buscarPorData(@RequestParam("entrada") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate entrada,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate saida, ModelMap model) {
		model.addAttribute("funcionario",funcServico.buscaPorData(entrada,saida));
		return "/funcionario/lista";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("funcionario", funcServico.bustarTodos());
		return "/funcionario/lista";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable Integer id, ModelMap model) {
		model.addAttribute("success", "o funcionario foi excluido com sucesso");
		funcServico.deletar(id);
		return "redirect:/funcionarios/listar";
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
