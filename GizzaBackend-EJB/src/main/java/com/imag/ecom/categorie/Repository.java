package com.imag.ecom.categorie;

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
@Stateless(name = "CategoryRepository")
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
	public Categorie add(Categorie c) {
		em.persist(c);
		return c;
	}

	@Override
	public Categorie update(Categorie c) {
		em.merge(c);
		return c;
	}

	@Override
	public void delete(Long id) {
		Categorie c = getByID(id);
		em.remove(c);

	}

	@Override
	public List<Categorie> getAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Categorie> criteria = cb.createQuery(Categorie.class);
		Root<Categorie> categorie = criteria.from(Categorie.class);
		criteria.select(categorie).orderBy(cb.asc(categorie.get("libelle")));
		return em.createQuery(criteria).getResultList();

	}

	@Override
	public Categorie getByID(Long id) {
		Categorie c = em.find(Categorie.class, id);
		return c;
	}

	@Override
	public Categorie getByName(String name) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Categorie> criteria = cb.createQuery(Categorie.class);
		Root<Categorie> categorie = criteria.from(Categorie.class);
		criteria.select(categorie).where(cb.equal(categorie.get("libelle"), name));
		return em.createQuery(criteria).getSingleResult();
	}

}
