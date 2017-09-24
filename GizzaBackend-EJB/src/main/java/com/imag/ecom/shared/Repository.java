package com.imag.ecom.shared;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public abstract class Repository<T> {

	@PersistenceContext
	private EntityManager em;
	private Class<T> entityClass;

	@Inject
	private Log logger;

	protected EntityManager getEntityManager() {
		return em;
	}

	public Repository(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	public T create(T entity) {
		try {
			getEntityManager().persist(entity);
			logger.logInfo("Entity" + entity.toString() + "has been created");
			return entity;
		} catch (Exception e) {
			getEntityManager().getTransaction().rollback();
			logger.logError(
					"We have an error with your request in " + entityClass.getName() + "with error:" + e.getMessage());
			return null;
		}
	}

	public T update(T entity) {
		try {
			getEntityManager().merge(entity);
			logger.logInfo("Entity" + entity.toString() + "has been updated");
			return entity;
		} catch (Exception e) {
			getEntityManager().getTransaction().rollback();
			logger.logError(
					"We have an error with your request in " + entityClass.getName() + "with error:" + e.getMessage());
			return null;
		}
	}

	public void remove(T entity) {
		try {
			getEntityManager().remove(getEntityManager().merge(entity));
			logger.logInfo("Entity" + entity.toString() + "has been removed");
		} catch (Exception e) {
			getEntityManager().getTransaction().rollback();
			logger.logError(
					"We have an error with your request in " + entityClass.getName() + "with error:" + e.getMessage());
		}
	}

	public T find(Object id) {
		try {
			return getEntityManager().find(entityClass, id);
		} catch (Exception e) {
			logger.logError(
					"We have an error with your request in " + entityClass.getName() + "with error:" + e.getMessage());
			return null;
		}
	}

	public List<T> findAll() {
		List<T> result = new ArrayList<>();
		try {
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<T> criteria = cb.createQuery(entityClass);
			criteria.select(criteria.from(entityClass));
			result.addAll(em.createQuery(criteria).getResultList());
			return result;
		} catch (Exception e) {
			logger.logError(
					"We have an error with your request in " + entityClass.getName() + "with error:" + e.getMessage());
			return result;
		}

	}

}
