package com.imag.ecom.produit;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.imag.ecom.shared.Repository;

/**
 * Session Bean implementation class Repository
 */
@Stateless(name = "ProduitRepository")
@LocalBean
public class ProduitRepository extends Repository<Produit> {

	/**
	 * Default constructor.
	 */
	public ProduitRepository() {
		super(Produit.class);
	}

}
