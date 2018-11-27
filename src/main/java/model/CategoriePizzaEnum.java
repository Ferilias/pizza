package model;

public enum CategoriePizzaEnum {

	FROMAGE("Fromage"),
	VIANDE("Viande"),
	POISSON("Poisson"),
	AUTRE("Autre");
	
	String nom;
	
	
	

	private CategoriePizzaEnum(String nom) {
		this.nom = nom;
	}
	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}

	public String toString() {
		return this.nom;
	}
	
	
	public static String toStringAll() {
		String msg = "";
		CategoriePizzaEnum [] tableauEnum = CategoriePizzaEnum.values();
		for (CategoriePizzaEnum categoriePizzaEnum : tableauEnum) {
			categoriePizzaEnum.toString();
			msg += categoriePizzaEnum.toString()+ "\r\n";
		}
		
		return msg;
	}
	
}
