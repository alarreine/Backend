package com.imag.ecom.commande;

import java.util.ArrayList;
import java.util.Collection;

public class ItemsCommandes {
	private Collection<ItemCommande> data = new ArrayList<>();
	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Collection<ItemCommande> getData() {
		return data;
	}

	public void setData(Collection<ItemCommande> data) {
		this.data = data;
	}

}
