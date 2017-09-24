package com.imag.ecom.commande;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.imag.ecom.produit.ProduitCommande;
import com.imag.ecom.user.User;

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
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "commande", fetch = FetchType.EAGER)
	private Set<ProduitCommande> produitsCommandes = new HashSet<ProduitCommande>();
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_user", foreignKey= @ForeignKey(name="FK_COMMANDE_USER"))
	private User user;
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

	public String getUserId() {
		return user.getEmail();
	}

	public void setUser(User user) {
		this.user = user;
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

	public void setProduitsCommandes(Set<ProduitCommande> produitsCommandes) {
		this.produitsCommandes = produitsCommandes;
	}

	@Override
	public String toString() {
		return "Commande [id=" + id + ", date=" + date + ", produitsCommandes=" + produitsCommandes + ", user=" + user
				+ "]";
	}

}
