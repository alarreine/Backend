package com.imag.ecom.produit.dessert;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

import com.imag.ecom.categorie.Categorie;
import com.imag.ecom.produit.Produit;

/**
 * Entity implementation class for Entity: Dessert
 *
 */
@Entity
@DiscriminatorValue("DESSERT")
public class Dessert extends Produit implements Serializable {

	private String nature;
	private double quantite;
	private static final long serialVersionUID = 1L;

	public Dessert() {
		super();
	}
	

	public Dessert(String nom, double prix, String url, Categorie categorie,String nature,double quantite) {
		super(nom, prix, url, categorie);
		this.nature=nature;
		this.quantite=quantite;
		// TODO Auto-generated constructor stub
	}


	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public double getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	

}
