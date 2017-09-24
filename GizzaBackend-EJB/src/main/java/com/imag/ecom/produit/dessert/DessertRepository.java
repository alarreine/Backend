package com.imag.ecom.produit.dessert;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.imag.ecom.produit.dessert.Dessert;
import com.imag.ecom.shared.Repository;

/**
 * Session Bean implementation class Repository
 */
@Stateless(name = "DessertRepository")
@LocalBean
public class DessertRepository extends Repository<Dessert> {

	/**
	 * Default constructor.
	 */
	public DessertRepository() {
		super(Dessert.class);

	}

	public Dessert getByName(String name) {
		CriteriaBuilder cb = super.getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Dessert> criteria = cb.createQuery(Dessert.class);
		Root<Dessert> dessert = criteria.from(Dessert.class);
		criteria.select(dessert).where(cb.equal(dessert.get("nom"), name));
		return super.getEntityManager().createQuery(criteria).getSingleResult();
	}

}
