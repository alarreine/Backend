package com.imag.ecom.produit;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.imag.ecom.categorie.Categorie;
import com.imag.ecom.commande.Commande;

/**
 * Entity implementation class for Entity: Produit
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)

public abstract class Produit implements Serializable {

	@Id
	@GeneratedValue
	private Long id;
	private String nom;
	private double prix;
	private String url;

	@ManyToOne
	@JoinColumn(name="id_categorie")
	private Categorie categorie;
	private static final long serialVersionUID = 1L;
	

	public Produit() {
		super();
	}

	public Produit(String nom, double prix, String url, Categorie categorie) {
		super();
		this.nom = nom;
		this.prix = prix;
		this.url = url;
		this.categorie = categorie;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return this.prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

}
