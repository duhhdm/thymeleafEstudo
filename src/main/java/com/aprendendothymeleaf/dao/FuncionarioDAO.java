package com.aprendendothymeleaf.dao;

import java.util.List;

import com.aprendendothymeleaf.domain.Funcionario;


public interface FuncionarioDAO {
	
	void save(Funcionario funcionario);
	void update(Funcionario funcionario);
	void delete(Integer id);
	Funcionario findById(Integer id);
	List<Funcionario> findAll();
	List<Funcionario> findByName(String nome);
	List<Funcionario> findByCargo(Integer id);
	
}
