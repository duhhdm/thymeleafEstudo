package com.aprendendothymeleaf.dao;


import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.aprendendothymeleaf.domain.Funcionario;
/*
 * e utilizado o comando sql do spring jpa para realizar uma consulta por nome
 * posso utilizar tambem o metodo createQuery() criado no AbstractDAO
 * ex: return createQuery("select f from Funcionario f where f.nome like concat('%',?1,'%')",nome);
 */
@Repository
public class FuncionarioDAOimpl extends AbstractDAO<Funcionario,Integer> implements FuncionarioDAO {
	
	public List<Funcionario> findByName(String nome){
		TypedQuery<Funcionario> query = getEntityManager()
				.createQuery("select f from Funcionario f where f.nome like :nome ", Funcionario.class);
		query.setParameter("nome", nome);
		return query.getResultList();
	}
	
	public List<Funcionario> findByCargo(Integer id){
		return createQuery("select f from Funcionario f where f.id_cargo=?1",id);
	}
}
