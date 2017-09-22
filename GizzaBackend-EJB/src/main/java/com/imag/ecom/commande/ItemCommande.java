package com.imag.ecom.commande;

public class ItemCommande {

	private Long idProduit;
	private int quantite;

	public ItemCommande() {
		super();
	}

	public ItemCommande(Long id_produit, int quantite) {
		super();
		this.idProduit = id_produit;
		this.quantite = quantite;
	}

	public Long getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(Long id_produit) {
		this.idProduit = id_produit;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

}
