package com.ejb.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public abstract class AbstractDao<T, I> {

	private Class<T> entityClass;
	
	public AbstractDao(Class<T> entityClass) {
		super();
		this.entityClass = entityClass;
	}

	public abstract EntityManager em();
	
	public void create(T entity){
		em().persist(entity);
	}
	
	public T update(T entity){
		return em().merge(entity);
	}
	
	public T findById(I id){
		return em().find(entityClass, id);
	}
	
	public void delete(T entity){
		em().remove(em().merge(entity));
	}
	
	public void deleteById(I id){
		T entity = findById(id);
		if(entity != null)
			em().remove(entity);
	}
	
	public List<T> findAll(){
		CriteriaBuilder cb = em().getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(entityClass);
		Root<T> root = cq.from(entityClass);
		//cq.select(root);
		return em().createQuery(cq).getResultList();
	}
}
