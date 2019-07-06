package com.aprendendothymeleaf.service;

import com.aprendendothymeleaf.domain.Funcionario;

public interface FuncionarioService {
	
	void salvar(Funcionario funcionario);
	void atualizar(Funcionario funcionario);
	void deletar(Integer id);
	Funcionario buscarId(Integer id);
	Funcionario bustarTodos();
	
}
