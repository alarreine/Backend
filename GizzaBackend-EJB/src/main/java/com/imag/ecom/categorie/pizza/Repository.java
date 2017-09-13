package com.imag.ecom.categorie.pizza;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Session Bean implementation class Repository
 */
@Stateless(name = "PizzaCategoryRepository")
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
	public PizzaCategorie add(PizzaCategorie c) {
		em.persist(c);
		return c;
	}

	@Override
	public PizzaCategorie update(PizzaCategorie c) {
		em.merge(c);
		return c;
	}

	@Override
	public void delete(Long id) {
		PizzaCategorie c = getByID(id);
		em.remove(c);

	}

	@Override
	public List<PizzaCategorie> getAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<PizzaCategorie> criteria = cb.createQuery(PizzaCategorie.class);
		Root<PizzaCategorie> categorie = criteria.from(PizzaCategorie.class);
		criteria.select(categorie).orderBy(cb.asc(categorie.get("nom")));
		return em.createQuery(criteria).getResultList();

	}

	@Override
	public PizzaCategorie getByID(Long id) {
		PizzaCategorie c = em.find(PizzaCategorie.class, id);
		return c;
	}

	@Override
	public PizzaCategorie getByName(String name) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<PizzaCategorie> criteria = cb.createQuery(PizzaCategorie.class);
		Root<PizzaCategorie> categorie = criteria.from(PizzaCategorie.class);
		criteria.select(categorie).where(cb.equal(categorie.get("libelle"), name));
		return em.createQuery(criteria).getSingleResult();
	}

}
