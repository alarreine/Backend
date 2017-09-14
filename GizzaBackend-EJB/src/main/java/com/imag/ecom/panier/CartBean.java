package com.imag.ecom.panier;

import java.util.Iterator;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;

/**
 * Session Bean implementation class CartBean
 */
@Stateful
@LocalBean
public class CartBean implements Cart {

	private List<CartItem> cart;

	public CartBean() {

	}

	@Override
	public void add(CartItem article, int quantite) {
		Iterator<CartItem> iter = cart.iterator();
		while (iter.hasNext()) {
			CartItem item = iter.next();
			if (item.getProduit().getNom().equals(article.getProduit().getNom())) {
				item.setQuantite(item.getQuantite() + quantite);
				return;
			}
		}
		article.setQuantite(quantite);
		cart.add(article);
	}

	@Override
	public boolean update(CartItem article, int nouvelleQuantite) {
		Iterator<CartItem> iter = cart.iterator();
		while (iter.hasNext()) {
			CartItem item = iter.next();
			if (item.getProduit().getNom().equals(article.getProduit().getNom())) {

				item.setQuantite(nouvelleQuantite);
				return true;
			}
		}
		return false;
	}

	@Override
	public void remove(CartItem article) {
		Iterator<CartItem> iter = cart.iterator();
		while (iter.hasNext()) {
			CartItem item = iter.next();
			if (item.getProduit().getNom().equals(article.getProduit().getNom())) {
				cart.remove(item);
				return;
			}
		}

	}

	@Override
	public int size() {
		return cart.size();
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public List<CartItem> getItems() {
		return cart;
	}

	@Override
	public void clear() {
		cart.clear();

	}

}
