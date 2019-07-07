package com.aprendendothymeleaf.service;

import java.util.List;

import com.aprendendothymeleaf.domain.Funcionario;

public interface FuncionarioService {
	
	void salvar(Funcionario funcionario);
	void atualizar(Funcionario funcionario);
	void deletar(Integer id);
	Funcionario buscarId(Integer id);
	List<Funcionario> bustarTodos();
	
}
