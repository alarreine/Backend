package com.imag.ecom.commande;

import java.util.ArrayList;
import java.util.Collection;

public class ItemsCommandes {
	private Collection<ItemCommande> data = new ArrayList<>();

	public Collection<ItemCommande> getData() {
		return data;
	}

	public void setData(Collection<ItemCommande> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ItemsCommandes [data=" + data + "]";
	}

}
