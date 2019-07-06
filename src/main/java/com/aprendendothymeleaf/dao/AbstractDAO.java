package com.aprendendothymeleaf.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


/*
 * Essa classe abstract ira funcionar como uma especie de DAO generico
 * na assinatura da classe temos dois tipos genericos. 
 * O T que vai representar a @Entity 
 * O PK que vai representar o tipo da ID da @Entity que pode ser um Long ou Integer ou outro
 * 
 */


public abstract class AbstractDAO<T,PK extends Serializable> {
	
	/* Atribuimos uma variavel entityClass do tipo Class<T> onde determina a @Entity
	 * a partir da assinatura da classe AbstractDAO onde recebe a classe na assinatura <T>
	 * essa variavel e necessario pois quando temos uma consulta precisamos saber o nome da classe
	 * e precisamos dizer qual e a @entity nos metodos de consulta por isso declaramos essa variavel.
	 */
	
	@SuppressWarnings("unchecked")
	private final Class<T> entityClass=
		(Class<T>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	
	/*
	 * o spring injeta essa variavel pela assinatura @PersistenceContext
	 * essa e uma expressao da propria JPA
	 * e temos o Get da variavel porque nao quero que essa variavel nao seja acessada
	 * alem das classes DAO 
	 */
	
	@PersistenceContext
	private EntityManager entityManager;
	
	protected EntityManager getEntityManager() {
		return entityManager;
	}
	
	public void save(T entity) {
		entityManager.persist(entity);
	}
	
	public void update(T entity) {
		entityManager.merge(entity);
	}
	
	public void delete(PK id) {
		entityManager.remove(entityManager.getReference(entityClass, id));
	}
	
	public T findById(PK id) {
		return entityManager.find(entityClass, id);
	}
	
	/*
	 * no metodo findAll() retornamos o metodo criado abaixo onde colocalmos o parametro jpql
	 * o comando sql FROM e o nome da classe utilizada como @Entity como exemplo
	 * "from Cargo" o segundo parametro é a @Entity exemplo "Cargo" 
	 */
	
	public List<T> findAll(){
		return entityManager.createQuery("from "+entityClass.getSimpleName(), entityClass)
				.getResultList();
	}
	
	/*
	 * o objeto String é para passar a jpql que vamos usar como parametro
	 * em seguida voce tem uma varavel params que e uma variavel varAs do tipo object
	 * para passar o valor dos parametros que voce vai adicionar a sua consulta
	 * quando utilizamos um metodo do tipo consulta junto a JPA temos que colocar sempre
	 * um objeto TypedQuery a partir do EntityManager usa o metodo createQuery
	 * para informar a classe de Entity referente a essa consulta
	 * logo em seguida temos que informar os parametros que foram informados nessa consulta
	 * para depois utilizar o metodo getResultList
	 */
	
	protected List<T> createQuery(String jpql, Object... params){
		TypedQuery<T> query = entityManager.createQuery(jpql, entityClass);
		for (int i=0; 1<params.length;i++) {
			query.setParameter(i+1, params[i]);
		}
		return query.getResultList();
	}
}
