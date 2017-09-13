package com.imag.ecom.produit.dessert;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.imag.ecom.produit.dessert.Dessert;

/**
 * Session Bean implementation class Repository
 */
@Stateless(name = "DessertRepository")
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
	public Dessert add(Dessert d) {
		em.persist(d);
		return d;
	}

	@Override
	public Dessert update(Dessert d) {
		em.merge(d);
		return d;
	}

	@Override
	public void delete(Long id) {
		Dessert b = getByID(id);
		em.remove(b);

	}

	@Override
	public List<Dessert> getAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Dessert> criteria = cb.createQuery(Dessert.class);
		Root<Dessert> dessert = criteria.from(Dessert.class);
		criteria.select(dessert).orderBy(cb.asc(dessert.get("nom")));
		return em.createQuery(criteria).getResultList();
	}

	@Override
	public Dessert getByID(Long id) {
		Dessert d = em.find(Dessert.class, id);
		return d;
	}

	@Override
	public Dessert getByName(String name) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Dessert> criteria = cb.createQuery(Dessert.class);
		Root<Dessert> dessert = criteria.from(Dessert.class);
		criteria.select(dessert).where(cb.equal(dessert.get("nom"), name));
		return em.createQuery(criteria).getSingleResult();
	}

}
