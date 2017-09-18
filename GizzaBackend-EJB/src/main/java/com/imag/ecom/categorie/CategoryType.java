package com.imag.ecom.categorie;

public enum CategoryType {

	PIZZA("pizza"), BOISSON("boisson"), DESSERT("dessert"), UNKNOW("");

	private String value;

	CategoryType(String value) {
		this.setValue(value);
	}

	// the valueOfMethod
	public static CategoryType fromString(String value) {
		switch (value) {
		case "Pizza":
			return PIZZA;
		case "Boisson":
			return BOISSON;
		case "Dessert":
			return DESSERT;
		default:
			return UNKNOW;
		}
	}

	public String toString() {
		switch (this) {
		case PIZZA:
			return "pizza";
		case BOISSON:
			return "boisson";
		case DESSERT:
			return "dessert";
		default:
			return "non défini";
		}
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
