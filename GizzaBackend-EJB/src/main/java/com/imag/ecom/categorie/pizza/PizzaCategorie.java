package com.imag.ecom.categorie.pizza;

import java.io.Serializable;
import javax.persistence.*;

import com.imag.ecom.categorie.Categorie;

/**
 * Entity implementation class for Entity: PizzaCategorie
 *
 */
@Entity
@DiscriminatorValue("PIZZA")
public class PizzaCategorie extends Categorie implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public PizzaCategorie() {
		super();
	}
   
}
