package com.imag.ecom.commande;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.imag.ecom.shared.Repository;

/**
 * Session Bean implementation class Repository
 */
@Stateless(name = "CommandeRepository")
@LocalBean
public class CommandeRepository extends Repository<Commande> {

	/**
	 * Default constructor.
	 */
	public CommandeRepository() {
		super(Commande.class);
	}

}
