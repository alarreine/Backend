package com.imag.ecom.shared;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public abstract class Repository<T> {

	@PersistenceContext
	private EntityManager em;
	private Class<T> entityClass;

	protected EntityManager getEntityManager() {
		return em;
	}

	public Repository(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	public T create(T entity) {
		getEntityManager().persist(entity);
		return entity;
	}

	public T update(T entity) {
		getEntityManager().merge(entity);
		return entity;
	}

	public void remove(T entity) {
		getEntityManager().remove(getEntityManager().merge(entity));
	}

	public T find(Object id) {
		return getEntityManager().find(entityClass, id);
	}

	public List<T> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<T> criteria = cb.createQuery(entityClass);
		criteria.select(criteria.from(entityClass));
		return em.createQuery(criteria).getResultList();
	}

}
