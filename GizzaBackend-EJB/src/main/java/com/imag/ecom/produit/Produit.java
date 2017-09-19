package com.imag.ecom.produit;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.imag.ecom.categorie.Categorie;

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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_categorie")
	private Categorie categorie;
	@OneToMany(mappedBy = "produit")
	private Set<ProduitCommande> produitsCommandes = new HashSet<ProduitCommande>();
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

	public Long getCategorieId() {
		if (this.categorie == null) {
			return null;
		}
		return this.categorie.getId();
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Set<ProduitCommande> getProduitsCommandes() {
		return produitsCommandes;
	}

	public void setUserGroups(Set<ProduitCommande> ProduitsCommandes) {
		this.produitsCommandes = ProduitsCommandes;
	}

	public void addProduitCommande(ProduitCommande produitCommande) {
		this.produitsCommandes.add(produitCommande);
	}

}
