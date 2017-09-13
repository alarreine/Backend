package com.imag.ecom.user;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Session Bean implementation class Repository
 */
@Stateless(name = "UserRepository")
@LocalBean
public class Repository implements RepositoryLocal {

	@PersistenceContext
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public Repository() {
		
	}

	@Override
	public User add(User u) {
		em.persist(u);
		return u;
	}

	@Override
	public User update(User u) {
		em.merge(u);
		return u;
	}

	@Override
	public void delete(Long id) {
		User u = getByID(id);
		em.remove(u);

	}

	@Override
	public List<User> getAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<User> criteria = cb.createQuery(User.class);
		Root<User> boisson = criteria.from(User.class);
		criteria.select(boisson).orderBy(cb.asc(boisson.get("nom")));
		return em.createQuery(criteria).getResultList();
	}

	@Override
	public User getByID(Long id) {
		User u = em.find(User.class, id);
		return u;
	}

	@Override
	public User getByName(String name) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<User> criteria = cb.createQuery(User.class);
		Root<User> boisson = criteria.from(User.class);
		criteria.select(boisson).where(cb.equal(boisson.get("nom"), name));
		return em.createQuery(criteria).getSingleResult();
	}

}
