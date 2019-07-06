package com.aprendendothymeleaf.service;

import java.util.List;

import com.aprendendothymeleaf.domain.Cargo;

public interface CargoService {
	
	void salvar(Cargo cargo);
	void atualizar(Cargo cargo);
	void deletar(Integer id);
	Cargo buscarId(Integer id);
	List<Cargo> bustarTodos();
	
}
