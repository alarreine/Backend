package com.imag.ecom.categorie.dessert;

import java.io.Serializable;
import javax.persistence.*;

import com.imag.ecom.categorie.Categorie;

/**
 * Entity implementation class for Entity: DessertCategorie
 *
 */
@Entity
@DiscriminatorValue("DESSERT")
public class DessertCategorie extends Categorie implements Serializable {

	private static final long serialVersionUID = 1L;

	public DessertCategorie() {
		super();
	}

}
