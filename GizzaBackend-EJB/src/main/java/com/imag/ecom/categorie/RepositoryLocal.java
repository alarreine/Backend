package com.imag.ecom.categorie;

import java.util.List;

import javax.ejb.Local;

@Local
public interface RepositoryLocal {
	public Categorie add(Categorie c);

	public Categorie update(Categorie c);

	public void delete(Long id);

	public List<Categorie> getAll();

	public Categorie getByID(Long id);

	public Categorie getByName(String name);

}
