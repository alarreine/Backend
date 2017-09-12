package com.imag.ecom.produit.pizza;

import java.util.List;

import javax.ejb.Local;

@Local
public interface RepositoryLocal {

	public Pizza add(Pizza p);
	public Pizza update(Pizza p);
	public void delete(Long id);
	public List<Pizza> getAll();
	public Pizza getByID(Long id);
	public Pizza getByName(String name);
	
}
