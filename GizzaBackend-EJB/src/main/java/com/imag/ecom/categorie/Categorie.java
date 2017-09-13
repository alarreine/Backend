package com.imag.ecom.categorie;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import com.imag.ecom.produit.Produit;

/**
 * Entity implementation class for Entity: Categorie
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public class Categorie implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@OneToMany(mappedBy = "categorie", fetch = FetchType.LAZY)
	private Collection<Produit> produits;
	private String libelle;
	private static final long serialVersionUID = 1L;

	public Categorie() {
		super();
	}

	
	public Categorie(String libelle) {
		super();
		this.libelle = libelle;
	}


	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Collection<Produit> getProduits() {
		return produits;
	}

	public void setProduits(Collection<Produit> produits) {
		this.produits = produits;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	

}
