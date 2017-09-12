package com.imag.ecom.produit.dessert;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

import com.imag.ecom.produit.Produit;

/**
 * Entity implementation class for Entity: Dessert
 *
 */
@Entity
@DiscriminatorValue("DESSERT")
public class Dessert extends Produit implements Serializable {

	private String nature;
	private static final long serialVersionUID = 1L;

	public Dessert() {
		super();
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

}
