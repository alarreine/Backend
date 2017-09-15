package com.imag.ecom.panier;

import java.util.List;

import javax.ejb.Local;

@Local
public interface Cart {

	public void add(CartItem article, int quantite);

	public boolean update(CartItem article,  int nouvelleQuantite);

	public void remove(CartItem article);

	public int size();

	public boolean isEmpty();

	public List<CartItem> getItems();

	public void clear();

}
