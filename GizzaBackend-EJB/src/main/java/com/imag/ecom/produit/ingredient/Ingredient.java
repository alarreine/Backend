package com.imag.ecom.produit.ingredient;

import java.io.Serializable;
import javax.persistence.*;

import com.imag.ecom.produit.Produit;

/**
 * Entity implementation class for Entity: Ingredient
 *
 */
@Entity
@DiscriminatorValue("INGREDIENT")
public class Ingredient extends Produit implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Ingredient() {
		super();
	}
   
}
