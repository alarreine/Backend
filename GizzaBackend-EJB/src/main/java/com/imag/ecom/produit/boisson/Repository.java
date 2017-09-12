package com.imag.ecom.produit.boisson;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


/**
 * Session Bean implementation class Repository
 */
@Stateless(name = "BoissonRepository")
@LocalBean
public class Repository implements RepositoryLocal {

	@Inject
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public Repository() {

	}

	@Override
	public Boisson add(Boisson b) {
		em.persist(b);
		return b;
	}

	@Override
	public Boisson update(Boisson b) {
		em.merge(b);
		return b;
	}

	@Override
	public void delete(Long id) {
		Boisson b = getByID(id);
		em.remove(b);

	}

	@Override
	public List<Boisson> getAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Boisson> criteria = cb.createQuery(Boisson.class);
		Root<Boisson> boisson = criteria.from(Boisson.class);
		criteria.select(boisson).orderBy(cb.asc(boisson.get("nom")));
		return em.createQuery(criteria).getResultList();
	}

	@Override
	public Boisson getByID(Long id) {
		Boisson b = em.find(Boisson.class, id);
		return b;
	}

	@Override
	public Boisson getByName(String name) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Boisson> criteria = cb.createQuery(Boisson.class);
		Root<Boisson> boisson = criteria.from(Boisson.class);
		criteria.select(boisson).where(cb.equal(boisson.get("nom"), name));
		return em.createQuery(criteria).getSingleResult();
	}

}
