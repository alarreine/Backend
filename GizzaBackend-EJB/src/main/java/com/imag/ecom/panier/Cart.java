package com.imag.ecom.panier;

import java.util.List;

import javax.ejb.Local;

@Local
public interface Cart {

	public void add(CartItem article, int quantite);

	public boolean update(int id, int quantite);

	public void remove(int id);

	public int size();

	public boolean isEmpty();

	public List<CartItem> getItems();

	public void clear();

}
