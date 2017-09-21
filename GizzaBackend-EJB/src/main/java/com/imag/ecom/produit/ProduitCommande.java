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
	@SequenceGenerator(name = "prod_com_seq", sequenceName = "prod_com_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prod_com_seq")
	private Long id;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_produit", foreignKey = @ForeignKey(name = "FK_PC_PRODUIT"))
	private Produit produit;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_commande", foreignKey = @ForeignKey(name = "FK_PC_COMMANDE"))
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

}
