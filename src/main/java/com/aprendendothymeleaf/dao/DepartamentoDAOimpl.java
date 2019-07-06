package com.aprendendothymeleaf.dao;

import org.springframework.stereotype.Repository;

import com.aprendendothymeleaf.domain.Departamento;

/*
 * Caso precisar de um novo metodo colocaremos aqui
 * e precisa declarar a assinatura na interface DepartamentoDAO
 * 
 */


@Repository
public class DepartamentoDAOimpl extends AbstractDAO<Departamento, Integer> implements DepartamentoDAO {
	
}
