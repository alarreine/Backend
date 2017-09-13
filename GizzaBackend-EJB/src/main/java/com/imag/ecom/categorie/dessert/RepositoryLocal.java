package com.imag.ecom.categorie.dessert;

import java.util.List;

import javax.ejb.Local;



@Local
public interface RepositoryLocal {
	public DessertCategorie add(DessertCategorie c);

	public DessertCategorie update(DessertCategorie c);

	public void delete(Long id);

	public List<DessertCategorie> getAll();

	public DessertCategorie getByID(Long id);

	public DessertCategorie getByName(String name);
}
