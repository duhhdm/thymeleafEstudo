package com.aprendendothymeleaf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aprendendothymeleaf.dao.CargoDAO;
import com.aprendendothymeleaf.domain.Cargo;

/*
 * @Transactional ja vem como padrão o valor readOnly=false
 * 
 */


@Service
@Transactional(readOnly=false)
public class CargoServiceImpl implements CargoService{

	@Autowired
	private CargoDAO daoCargo;
	
	@Override
	public void salvar(Cargo cargo) {
		// TODO Auto-generated method stub
		daoCargo.save(cargo);
	}

	@Override
	public void atualizar(Cargo cargo) {
		// TODO Auto-generated method stub
		daoCargo.update(cargo);
	}

	@Override
	public void deletar(Integer id) {
		// TODO Auto-generated method stub
		daoCargo.delete(id);
	}

	@Transactional(readOnly=true)
	@Override
	public Cargo buscarId(Integer id) {
		// TODO Auto-generated method stub
		return daoCargo.findById(id);
	}

	@Transactional(readOnly=true)
	@Override
	public List<Cargo> bustarTodos() {
		// TODO Auto-generated method stub
		return daoCargo.findAll();
	}

	@Override
	public boolean temFuncionario(Integer id) {
		// TODO Auto-generated method stub
		Cargo aux = buscarId(id);
		if(aux.getFuncionario().isEmpty())
			return true;
		else
			return false;
	}

}
