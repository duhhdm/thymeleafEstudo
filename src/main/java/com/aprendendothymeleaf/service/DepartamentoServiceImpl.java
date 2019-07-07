package com.aprendendothymeleaf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aprendendothymeleaf.dao.DepartamentoDAO;
import com.aprendendothymeleaf.domain.Departamento;

@Service
@Transactional(readOnly=false)
public class DepartamentoServiceImpl implements DepartamentoService{

	@Autowired
	private DepartamentoDAO departamentoDao;
	
	@Override
	public void salvar(Departamento departamento) {
		// TODO Auto-generated method stub
		departamentoDao.save(departamento);
	}

	@Override
	public void atualizar(Departamento departamento) {
		// TODO Auto-generated method stub
		departamentoDao.update(departamento);
	}

	@Override
	public void deletar(Integer id) {
		// TODO Auto-generated method stub
		departamentoDao.delete(id);
	}

	@Transactional(readOnly=true)
	@Override
	public Departamento buscarId(Integer id) {
		// TODO Auto-generated method stub
		return departamentoDao.findById(id);
	}

	@Transactional(readOnly=true)
	@Override
	public List<Departamento> bustarTodos() {
		// TODO Auto-generated method stub
		return departamentoDao.findAll();
	}

	@Override
	public boolean departamentoTemCargos(Integer id) {
		// TODO Auto-generated method stub
		Departamento aux = buscarId(id);
		if(aux.getCargos().isEmpty())
			return false;
		else
			return true;
	}
	
}
