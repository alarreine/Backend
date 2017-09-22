package com.imag.ecom.produit;

import com.imag.ecom.commande.Commande;
import com.imag.ecom.produit.Produit;

import java.io.Serializable;
import java.lang.Long;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ProduitCommande
 *
 */
@Entity
@Table(name = "Produit_Commande")
public class ProduitCommande implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_produit")
	private Produit produit;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_commande")
	private Commande commande;
	private int quantite;
	private static final long serialVersionUID = 1L;

	public ProduitCommande() {
		super();
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public int getQuantite() {
		return this.quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public String getNom() {
		return produit.getNom();
	}

	public String getUrl() {
		return produit.getUrl();
	}

	public double getPrix() {
		return produit.getPrix();
	}

	public String getCategorie() {

		return produit.getType();
	}

}
