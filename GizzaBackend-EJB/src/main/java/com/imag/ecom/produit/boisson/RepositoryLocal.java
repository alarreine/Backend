package com.imag.ecom.produit.boisson;

import java.util.List;

import javax.ejb.Local;

@Local
public interface RepositoryLocal {
	public Boisson add(Boisson b);

	public Boisson update(Boisson b);

	public void delete(Long id);

	public List<Boisson> getAll();

	public Boisson getByID(Long id);

	public Boisson getByName(String name);
}
