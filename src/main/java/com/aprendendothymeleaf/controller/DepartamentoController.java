package com.aprendendothymeleaf.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aprendendothymeleaf.domain.Departamento;
import com.aprendendothymeleaf.service.DepartamentoService;

@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {
	
	@Autowired
	private DepartamentoService servico;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Departamento departamento) {
		return "/departamento/cadastro";
	}
	
	/*
	 * Utilizei o ModelMap com o atributo model.addAttribute 
	 * para adicionar ao thymeleaf a List<Departamento>
	 * que o metodo servico.buscarTodos() retorna e apelidei como departamento
	 * 
	 */
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("departamento", servico.bustarTodos());
		return "/departamento/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(Departamento departamento, RedirectAttributes obj){
		servico.salvar(departamento);
		obj.addFlashAttribute("success", "Departamento Criado com sucesso!");
		return "redirect:/departamentos/cadastrar"; //redirect:/pagina desejada ele redireciona para a pagina desejada
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Integer id, ModelMap model) {
		model.addAttribute("departamento", servico.buscarId(id));
		return "/departamento/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Departamento departamento, RedirectAttributes obj) {
		servico.atualizar(departamento);
		obj.addFlashAttribute("success", "Departamento editado com sucesso!");
		return "redirect:/departamentos/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String deletar(@PathVariable("id") Integer id, ModelMap model) {
		if(servico.departamentoTemCargos(id))
			model.addAttribute("fail","Departamento não pode ser removido!");
		else {
			servico.deletar(id);
			model.addAttribute("success","Departamento removido com sucesso!");
		}
		return listar(model);
	}
}
