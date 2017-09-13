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
				item.setQuantite(item.getQuantite()+quantite);
				return;
			}
		}
		article.setQuantite(quantite);
		cart.add(article);
	}

	@Override
	public boolean update(int id, int newQty) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void remove(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<CartItem> getItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

}
