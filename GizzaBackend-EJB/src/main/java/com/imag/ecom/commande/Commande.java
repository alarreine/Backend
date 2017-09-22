package com.imag.ecom.commande;

import com.imag.ecom.produit.ProduitCommande;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Entity implementation class for Entity: Commande
 *
 */
@Entity

public class Commande implements Serializable {

	@Id
	@SequenceGenerator(name = "commande_seq", sequenceName = "commande_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "commande_seq")
	private Long id;
	@Temporal(TemporalType.DATE)
	private Date date;
	@OneToMany(mappedBy = "commande",fetch = FetchType.EAGER)
	private Set<ProduitCommande> produitsCommandes = new HashSet<ProduitCommande>();
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

	public Set<ProduitCommande> getProduitsCommandes() {
		return produitsCommandes;
	}

	public void setUserGroups(Set<ProduitCommande> ProduitsCommandes) {
		this.produitsCommandes = ProduitsCommandes;
	}

	public void addProduitCommande(ProduitCommande produitCommande) {
		this.produitsCommandes.add(produitCommande);
	}

}
