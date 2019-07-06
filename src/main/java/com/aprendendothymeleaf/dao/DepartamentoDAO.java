package com.aprendendothymeleaf.dao;

import java.util.List;

import com.aprendendothymeleaf.domain.Departamento;

public interface DepartamentoDAO {
	
	void save(Departamento departamento);
	void update(Departamento departamento);
	void delete(Integer id);
	Departamento findById(Integer id);
	List<Departamento> findAll();
	
}
