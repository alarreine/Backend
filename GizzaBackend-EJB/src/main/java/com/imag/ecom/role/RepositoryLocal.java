package com.imag.ecom.role;

import javax.ejb.Local;

@Local
public interface RepositoryLocal {
	public Role add(Role r);

	public Role update(Role r);

	public void delete(Long id);

	public Role getByID(Long id);

	public Role getByName(String name);
}
