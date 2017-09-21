package com.imag.ecom.categorie;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

import com.imag.ecom.produit.Produit;
import com.imag.ecom.shared.CategoryType;

/**
 * Entity implementation class for Entity: Categorie
 *
 */
@Entity
@XmlRootElement
public class Categorie implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String libelle;
	@Enumerated(EnumType.STRING)
	private CategoryType type;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "categorie", cascade = CascadeType.ALL)
	private List<Produit> produits;

	private static final long serialVersionUID = 1L;

	public Categorie() {
		super();
	}

	public Categorie(String libelle, CategoryType type) {
		super();
		this.libelle = libelle;
		this.type = type;
	}

	public CategoryType getType() {
		return type;
	}

	public void setType(CategoryType type) {
		this.type = type;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public void addProduit(Produit p) {
		this.produits.add(p);
	}

}
