package com.imag.ecom.user;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import org.hibernate.validator.constraints.Email;

import com.imag.ecom.role.Role;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity

public class User implements Serializable {

	   
	@Id
	@Email
	private String email;
	private String password;
	private String nom;
	private String prenom;
	private String telephone;
	private String adresse;
	@ManyToOne
	@JoinColumn(name="role")
	private Role role;
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}  
	
	
	public User(String email, String password, String nom, String prenom, String telephone, String adresse,
			Role role) {
		super();
		this.email = email;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.adresse = adresse;
		this.role = role;
	}


	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}   
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}   
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}   
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}   
	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
   
}
