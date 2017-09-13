package com.imag.ecom.categorie.pizza;

import java.util.List;

import javax.ejb.Local;

import com.imag.ecom.categorie.pizza.PizzaCategorie;;

@Local
public interface RepositoryLocal {
	public PizzaCategorie add(PizzaCategorie c);

	public PizzaCategorie update(PizzaCategorie c);

	public void delete(Long id);

	public List<PizzaCategorie> getAll();

	public PizzaCategorie getByID(Long id);

	public PizzaCategorie getByName(String name);

}
