package com.imag.ecom.commande;

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
@Stateless(name = "CommandeRepository")
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
	public Commande add(Commande c) {
		em.persist(c);
		return c;
	}

	@Override
	public Commande update(Commande c) {
		em.merge(c);
		return c;
	}

	@Override
	public void delete(Long id) {
		Commande c = getByID(id);
		em.remove(c);

	}

	@Override
	public List<Commande> getAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Commande> criteria = cb.createQuery(Commande.class);
		Root<Commande> commande = criteria.from(Commande.class);
		criteria.select(commande).orderBy(cb.asc(commande.get("libelle")));
		return em.createQuery(criteria).getResultList();

	}

	@Override
	public Commande getByID(Long id) {
		Commande c = em.find(Commande.class, id);
		return c;
	}

	@Override
	public Commande getByName(String name) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Commande> criteria = cb.createQuery(Commande.class);
		Root<Commande> commande = criteria.from(Commande.class);
		criteria.select(commande).where(cb.equal(commande.get("libelle"), name));
		return em.createQuery(criteria).getSingleResult();
	}

}
