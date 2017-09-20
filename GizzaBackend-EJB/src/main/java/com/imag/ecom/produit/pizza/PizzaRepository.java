package com.imag.ecom.produit.pizza;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.imag.ecom.shared.Repository;

/**
 * Session Bean implementation class Repository
 */
@Stateless(name = "PizzaRepository")
@LocalBean
public class PizzaRepository extends Repository<Pizza> {

	/**
	 * Default constructor.
	 */
	public PizzaRepository() {
		super(Pizza.class);
	}

	public Pizza getByName(String name) {
		CriteriaBuilder cb = super.getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Pizza> criteria = cb.createQuery(Pizza.class);
		Root<Pizza> pizza = criteria.from(Pizza.class);
		criteria.select(pizza).where(cb.equal(pizza.get("nom"), name));
		return super.getEntityManager().createQuery(criteria).getSingleResult();

	}

}
