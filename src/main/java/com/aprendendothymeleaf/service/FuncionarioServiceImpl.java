package com.aprendendothymeleaf.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aprendendothymeleaf.dao.FuncionarioDAO;
import com.aprendendothymeleaf.domain.Funcionario;
@Service
@Transactional(readOnly=false)
public class FuncionarioServiceImpl implements FuncionarioService{

	@Autowired
	private FuncionarioDAO funcionarioDao;
	
	@Override
	public void salvar(Funcionario funcionario) {
		// TODO Auto-generated method stub
		funcionarioDao.save(funcionario);
	}

	@Override
	public void atualizar(Funcionario funcionario) {
		// TODO Auto-generated method stub
		funcionarioDao.update(funcionario);
	}

	@Override
	public void deletar(Integer id) {
		// TODO Auto-generated method stub
		funcionarioDao.delete(id);
	}
	
	@Transactional(readOnly=true)
	@Override
	public Funcionario buscarId(Integer id) {
		// TODO Auto-generated method stub
		return funcionarioDao.findById(id);
	}

	@Transactional(readOnly=true)
	@Override
	public List<Funcionario> bustarTodos() {
		// TODO Auto-generated method stub
		return funcionarioDao.findAll();
	}

	@Override
	public List<Funcionario> buscarPorNome(String nome) {
		// TODO Auto-generated method stub
		return funcionarioDao.findByName(nome);
	}

	@Override
	public List<Funcionario> buscarPorCargo(Integer id) {
		// TODO Auto-generated method stub
		return funcionarioDao.findByCargo(id);
	}

	@Override
	public List<Funcionario> buscaPorData(LocalDate entrada, LocalDate saida) {
		// TODO Auto-generated method stub
		if(entrada!=null && saida!=null)
			return funcionarioDao.findByData(entrada, saida);
		else if(entrada != null)
			return funcionarioDao.findByEntrada(entrada);
		else if(saida != null)
			return funcionarioDao.findBysaida(saida);
		else {
			return new ArrayList<>();
		}
	}
	
}
