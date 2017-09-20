package com.imag.ecom.produit.pizza;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.imag.ecom.categorie.Categorie;

/**
 * Session Bean implementation class Repository
 */
@Stateless(name = "PizzaRepository")
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
	public Pizza add(Pizza p) {

		em.persist(p);
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
		Pizza p = em.find(Pizza.class, id);
		return p;
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
