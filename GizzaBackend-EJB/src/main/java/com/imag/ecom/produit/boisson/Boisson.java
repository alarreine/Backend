package com.imag.ecom.produit.boisson;

import java.io.Serializable;
import javax.persistence.*;

import com.imag.ecom.produit.Produit;

/**
 * Entity implementation class for Entity: Boisson
 *
 */
@Entity
@DiscriminatorValue("BOISSON")
public class Boisson extends Produit implements Serializable {

	private double format;
	private static final long serialVersionUID = 1L;

	public Boisson() {
		super();
	}

	public double getFormat() {
		return this.format;
	}

	public void setFormat(double format) {
		this.format = format;
	}

}
