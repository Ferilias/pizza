package com.pizzeria;

import exception.StockageException;
import model.CategoriePizzaEnum;

/**
 * Initialisation des attributs de la class pizza.
 * 
 * @author Alexandre
 *
 */
public class Pizza {
	int id;
	String code;
	String designation;
	double prix;
	static int count;
	CategoriePizzaEnum categorie;
	/**
	 * Constructeur
	 * 
	 * @param code        (3 lettres en majuscule)
	 * @param designation de la pizza
	 * @param prix        de la pizza en € avec une virugule
	 */
	public Pizza(String code, String designation, double prix, CategoriePizzaEnum cat) {
		this.id = ++count;
		this.code = code;
		this.designation = designation;
		this.prix = prix;
		this.categorie = cat;
	}
	
	public static final int MAXIMUM_CARAC_CODE = 4;
	public static final int MAXIMUM_CARAC_PIZZA = 20;
	public static final int PRIX_PIZZA_MAXIMUM = 30;
	public static final int PRIX_PIZZA_MINIMUM = 4;

	/**
	 * Getter et setter de la class pizza
	 * 
	 * @return le code de 3 lettres
	 */
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
	public CategoriePizzaEnum getCategorie() {
		return categorie;
	}

	public void setCategorie(CategoriePizzaEnum categorie) {
		this.categorie = categorie;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return code + " -> " + designation + " - "+categorie+" (" + prix + ") ";
	}

	public static String settingMenu() {
		return "***** Pizzeria Administration *****  \n" + "1. \t Lister les pizzas \n"
				+ "2. \t Ajouter une nouvelle pizza \n" + "3. \t Mettre à jour une pizza \n"
				+ "4. \t Supprimer une pizza \n" + "99. \t Sortir \n";
	}

	public void dataControl () throws StockageException {
		String message = " ";
		
		if (code.trim().length() < 0 || code == null || code.trim().length() > MAXIMUM_CARAC_CODE) {
			message += "Le code est invalide ou nul, il doit avoir entre 0 et "+MAXIMUM_CARAC_CODE+" caractères \r\n";
		}
		
		if (designation.trim().length() < 0 || designation == null || designation.trim().length() > MAXIMUM_CARAC_PIZZA) {
			message += "Le code est invalide ou nul, il doit avoir entre 0 et "+MAXIMUM_CARAC_PIZZA+" caractères \r\n";
		}
		
		if (prix < PRIX_PIZZA_MINIMUM || prix > PRIX_PIZZA_MAXIMUM) {
			message += "Le prix est invalide ou nul, il  doit être compris entre : "+PRIX_PIZZA_MINIMUM+" et "+PRIX_PIZZA_MAXIMUM;
		}
		if (message.trim().length() > 0) {
			throw new StockageException(message);
		}
	}
}
