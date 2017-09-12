package com.imag.ecom.produit.dessert;

import java.util.List;

import javax.ejb.Local;

@Local
public interface RepositoryLocal {
	public Dessert add(Dessert d);

	public Dessert update(Dessert d);

	public void delete(Long id);

	public List<Dessert> getAll();

	public Dessert getByID(Long id);

	public Dessert getByName(String name);

}
