package com.imag.ecom.user;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;

import com.imag.ecom.commande.Commande;
import com.imag.ecom.shared.Role;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@Table(name = "Utilisateur")
@NamedQueries({
		@NamedQuery(name = "User.role", query = "SELECT u.role FROM User u WHERE u.email = :username AND u.password = :password"),
		@NamedQuery(name = "User.get", query = "SELECT u FROM User u WHERE u.email = :username AND u.password = :password") })
public class User implements Serializable {

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Id
	@Email
	private String email;
	private String password;
	private String nom;
	private String prenom;
	private String telephone;
	private String adresse;
	@Enumerated(EnumType.STRING)
	private Role role;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
	private List<Commande> commandes;
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}

	public User(String email, String password, String nom, String prenom, String telephone, String adresse, Role role) {
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

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	public void addCommande(Commande c) {
		this.commandes.add(c);
	}

}
