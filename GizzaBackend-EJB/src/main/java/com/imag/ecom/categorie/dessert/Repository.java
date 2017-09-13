package com.imag.ecom.categorie.dessert;

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
@Stateless(name = "DessertCategorieRepository")
@LocalBean
public class Repository implements RepositoryLocal {

	@PersistenceContext
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public Repository() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public DessertCategorie add(DessertCategorie c) {
		em.persist(c);
		return c;
	}

	@Override
	public DessertCategorie update(DessertCategorie c) {
		em.merge(c);
		return c;
	}

	@Override
	public void delete(Long id) {
		DessertCategorie c = getByID(id);
		em.remove(c);

	}

	@Override
	public List<DessertCategorie> getAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<DessertCategorie> criteria = cb.createQuery(DessertCategorie.class);
		Root<DessertCategorie> categorie = criteria.from(DessertCategorie.class);
		criteria.select(categorie).orderBy(cb.asc(categorie.get("libelle")));
		return em.createQuery(criteria).getResultList();
	}

	@Override
	public DessertCategorie getByID(Long id) {
		DessertCategorie c = em.find(DessertCategorie.class, id);
		return c;
	}

	@Override
	public DessertCategorie getByName(String name) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<DessertCategorie> criteria = cb.createQuery(DessertCategorie.class);
		Root<DessertCategorie> categorie = criteria.from(DessertCategorie.class);
		criteria.select(categorie).where(cb.equal(categorie.get("libelle"), name));
		return em.createQuery(criteria).getSingleResult();
	}

}
