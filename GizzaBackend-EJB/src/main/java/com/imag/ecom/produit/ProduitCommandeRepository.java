package com.imag.ecom.produit;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.imag.ecom.shared.Repository;

/**
 * Session Bean implementation class Repository
 */
@Stateless(name = "ProduitCommandeRepository")
@LocalBean
public class ProduitCommandeRepository extends Repository<ProduitCommande> {

	/**
	 * Default constructor.
	 */
	public ProduitCommandeRepository() {
		super(ProduitCommande.class);
	}

}
