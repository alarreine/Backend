package com.imag.ecom.user;

import java.util.List;

import javax.ejb.Local;



@Local
public interface RepositoryLocal {
	public User add(User u);

	public User update(User u);

	public void delete(Long id);

	public List<User> getAll();

	public User getByID(Long id);

	public User getByName(String name);
	
}
