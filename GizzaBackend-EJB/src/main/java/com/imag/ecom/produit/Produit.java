package com.imag.ecom.produit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

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
	@SequenceGenerator(name = "prod_seq", sequenceName = "prod_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prod_seq")
	private Long id;
	private String nom;
	private double prix;
	private String url;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_categorie", foreignKey = @ForeignKey(name = "FK_PROD_CAT"))
	private Categorie categorie;
//	@OneToMany(fetch = FetchType.EAGER, mappedBy = "produit")
//	private List<ProduitCommande> produitsCommandes;
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
			return this.categorie.getId();
		}
		return this.categorie.getId();
	}

	public String getType() {
		return this.categorie.getType().toString();
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

//	public List<ProduitCommande> getProduitsCommandes() {
//		return produitsCommandes;
//	}
//
//	public void setUserGroups(List<ProduitCommande> ProduitsCommandes) {
//		this.produitsCommandes = ProduitsCommandes;
//	}
//
//	public void addProduitCommande(ProduitCommande produitCommande) {
//		this.produitsCommandes.add(produitCommande);
//	}

	@Override
	public String toString() {
		return "Produit [id=" + id + ", nom=" + nom + ", prix=" + prix + ", url=" + url + ", categorie=" + categorie
				+ "]";
	}

}
