package com.imag.ecom.produit.boisson;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.imag.ecom.shared.Repository;

/**
 * Session Bean implementation class Repository
 */
@Stateless(name = "BoissonRepository")
@LocalBean
public class BoissonRepository extends Repository<Boisson> {

	/**
	 * Default constructor.
	 */
	public BoissonRepository() {
		super(Boisson.class);
	}

	public Boisson getByName(String name) {
		CriteriaBuilder cb = super.getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Boisson> criteria = cb.createQuery(Boisson.class);
		Root<Boisson> boisson = criteria.from(Boisson.class);
		criteria.select(boisson).where(cb.equal(boisson.get("nom"), name));
		return super.getEntityManager().createQuery(criteria).getSingleResult();
	}

}
