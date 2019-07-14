package com.aprendendothymeleaf.service;

import java.time.LocalDate;
import java.util.List;

import com.aprendendothymeleaf.domain.Funcionario;

public interface FuncionarioService {
	
	void salvar(Funcionario funcionario);
	void atualizar(Funcionario funcionario);
	void deletar(Integer id);
	Funcionario buscarId(Integer id);
	List<Funcionario> bustarTodos();
	List<Funcionario> buscarPorNome(String nome);
	List<Funcionario> buscarPorCargo(Integer id);
	List<Funcionario> buscaPorData(LocalDate entrada, LocalDate saida);
	
}
