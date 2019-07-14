package com.aprendendothymeleaf.dao;


import java.time.LocalDate;
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
		TypedQuery<Funcionario> query = getEntityManager()
				.createQuery("SELECT f FROM Funcionario f INNER JOIN f.cargo c WHERE c.id = :id ", Funcionario.class);
		query.setParameter("id", id);
		return query.getResultList();
	}
	
	public List<Funcionario> findByData(LocalDate entrada, LocalDate saida){
		TypedQuery<Funcionario> query = getEntityManager()
				.createQuery("SELECT f FROM Funcionario f WHERE f.dataEntrada >= :entrada AND f.dataSaida <= :saida"
						+ "order by f.data_ent asc",Funcionario.class);
		query.setParameter("entrada",entrada);
		query.setParameter("saida", saida);
		return query.getResultList();
	}

	@Override
	public List<Funcionario> findByEntrada(LocalDate entrada) {
		// TODO Auto-generated method stub
		TypedQuery<Funcionario> query = getEntityManager()
				.createQuery("SELECT f FROM Funcionario f WHERE f.dataEntrada = :entrada",Funcionario.class);
		query.setParameter("entrada",entrada);
		return query.getResultList();
	}

	@Override
	public List<Funcionario> findBysaida(LocalDate saida) {
		// TODO Auto-generated method stub
		TypedQuery<Funcionario> query = getEntityManager()
				.createQuery("SELECT f FROM Funcionario f WHERE f.dataSaida = :saida",Funcionario.class);
		query.setParameter("saida",saida);
		return query.getResultList();
	}
}
