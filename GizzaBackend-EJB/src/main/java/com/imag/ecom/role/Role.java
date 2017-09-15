package com.imag.ecom.role;

import java.io.Serializable;
import java.lang.String;
import java.util.Collection;

import javax.persistence.*;

import com.imag.ecom.user.User;

/**
 * Entity implementation class for Entity: Role
 *
 */
@Entity

public class Role implements Serializable {

	@Id
	private String libelle;

	@OneToMany(mappedBy="role")
	private Collection<User> users;
	private static final long serialVersionUID = 1L;

	public Role() {
		super();
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

}
