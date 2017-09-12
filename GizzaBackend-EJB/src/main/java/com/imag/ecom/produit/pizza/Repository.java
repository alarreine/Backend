package com.imag.ecom.produit.pizza;

import java.util.List;
import java.util.logging.Logger;

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
@Stateless
@LocalBean
public class Repository implements RepositoryLocal {

	@Inject
	EntityManager em;
	@Inject
	Logger log;

	/**
	 * Default constructor.
	 */
	public Repository() {

	}

	@Override
	public Pizza add(Pizza p) {
		em.persist(p);
		log.info("Enrégistrement de la pizza " + p.getNom());
		return p;
	}

	@Override
	public Pizza update(Pizza p) {
		em.merge(p);
		return p;
	}

	@Override
	public void delete(Long id) {
		Pizza p = getByID(id);
		em.remove(p);

	}

	@Override
	public List<Pizza> getAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Pizza> criteria = cb.createQuery(Pizza.class);
		Root<Pizza> pizza = criteria.from(Pizza.class);
		criteria.select(pizza).orderBy(cb.asc(pizza.get("nom")));
		return em.createQuery(criteria).getResultList();

	}

	@Override
	public Pizza getByID(Long id) {
		em.find(Pizza.class, id);
		return null;
	}

	@Override
	public Pizza getByName(String name) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Pizza> criteria = cb.createQuery(Pizza.class);
		Root<Pizza> pizza = criteria.from(Pizza.class);
		criteria.select(pizza).where(cb.equal(pizza.get("nom"), name));
		return em.createQuery(criteria).getSingleResult();

	}

}
