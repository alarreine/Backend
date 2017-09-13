package com.imag.ecom.categorie.boisson;

import java.io.Serializable;
import javax.persistence.*;

import com.imag.ecom.categorie.Categorie;

/**
 * Entity implementation class for Entity: BoissonCategorie
 *
 */
@Entity
@DiscriminatorValue("BOISSON")
public class BoissonCategorie extends Categorie implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public BoissonCategorie() {
		super();
	}

	public BoissonCategorie(String libelle) {
		super(libelle);
	}
   
}
