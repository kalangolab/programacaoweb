package br.com.kalango.lab.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public abstract class BaseDAO<T> {

	@PersistenceContext(unitName = "livrariaPU")
	private EntityManager em;
	
	public Class<T> tipo;
	
	
	public BaseDAO(){}
	
	public BaseDAO(Class<T> tipo){
		this.tipo = tipo;
	}
	
	
	public void salvar(T tipo){
		em.persist(tipo);
	}
	
	public T atualizar(T tipo){
		return em.merge(tipo);
	}
	
	public List<T> listarTodos(){
		StringBuilder sql = new StringBuilder();
		sql.append("from ").append(tipo.getSimpleName());
		
		Query q = em.createQuery(sql.toString());
		
		return q.getResultList();
	}
	
	

}
