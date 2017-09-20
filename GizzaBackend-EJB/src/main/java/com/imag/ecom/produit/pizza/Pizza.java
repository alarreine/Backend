package com.imag.ecom.produit.pizza;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

import com.imag.ecom.categorie.Categorie;
import com.imag.ecom.produit.Produit;

/**
 * Entity implementation class for Entity: Pizza
 *
 */
@Entity
@DiscriminatorValue("PIZZA")
public class Pizza extends Produit implements Serializable {

	private String description;
	private static final long serialVersionUID = 1L;

	public Pizza() {
		super();
	}

	public Pizza(Categorie categorie, String nom, String description, double prix, String url) {
		super(nom, prix, url, categorie);
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
