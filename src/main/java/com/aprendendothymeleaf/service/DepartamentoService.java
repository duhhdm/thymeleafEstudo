package com.aprendendothymeleaf.service;

import com.aprendendothymeleaf.domain.Departamento;

public interface DepartamentoService {

	void salvar(Departamento departamento);
	void atualizar(Departamento departamento);
	void deletar(Integer id);
	Departamento buscarId(Integer id);
	Departamento bustarTodos();
	
}
