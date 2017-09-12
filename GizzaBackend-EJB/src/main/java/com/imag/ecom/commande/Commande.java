package com.imag.ecom.commande;

import java.io.Serializable;
import java.lang.Long;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;

import com.imag.ecom.produit.Produit;

/**
 * Entity implementation class for Entity: Commande
 *
 */
@Entity

public class Commande implements Serializable {

	   
	@Id
	@GeneratedValue
	private Long id;
	private Date date;
	@ManyToMany
	private Collection<Produit> produits;
	private static final long serialVersionUID = 1L;

	public Commande() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
   
}
