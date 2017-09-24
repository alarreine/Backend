package com.imag.ecom.categorie;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.imag.ecom.shared.CategoryType;
import com.imag.ecom.shared.Repository;

/**
 * Session Bean implementation class Repository
 */
@Stateless(name = "CategoryRepository")
@LocalBean
public class CategorieRepository extends Repository<Categorie> {

	/**
	 * Default constructor.
	 */
	public CategorieRepository() {
		super(Categorie.class);
	}

	public Categorie getByName(String name) {
		CriteriaBuilder cb = super.getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Categorie> criteria = cb.createQuery(Categorie.class);
		Root<Categorie> categorie = criteria.from(Categorie.class);
		criteria.select(categorie).where(cb.equal(categorie.get("libelle"), name));
		return super.getEntityManager().createQuery(criteria).getSingleResult();
	}

	public List<Categorie> getByType(CategoryType type) {
		CriteriaBuilder cb = super.getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Categorie> criteria = cb.createQuery(Categorie.class);
		Root<Categorie> categorie = criteria.from(Categorie.class);
		criteria.select(categorie).where(cb.equal(categorie.get("type"), type));
		return super.getEntityManager().createQuery(criteria).getResultList();
	}

}
