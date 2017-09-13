package com.imag.ecom.commande;

import java.util.List;

import javax.ejb.Local;

@Local
public interface RepositoryLocal {
	public Commande add(Commande c);

	public Commande update(Commande c);

	public void delete(Long id);

	public List<Commande> getAll();

	public Commande getByID(Long id);

	public Commande getByName(String name);
}
