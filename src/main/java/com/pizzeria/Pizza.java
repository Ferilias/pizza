package com.pizzeria;

/**
 * Initialisation des attributs de la class pizza.
 * @author Alexandre
 *
 */
public class Pizza {
	int id;
	String code;
	String designation;
	double prix;
	static int count;
	
	/**
	 * Constructeur
	 * @param code (3 lettres en majuscule)
	 * @param designation de la pizza
	 * @param prix de la pizza en € avec une virugule
	 */
	public Pizza (String code, String designation, double prix) {
		this.id = ++count;
		this.code = code;
		this.designation = designation;
		this.prix = prix;
	}

/**
 * Getter et setter de la class pizza
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


	public double getPrix() {
		return prix;
	}


	public void setPrix(double prix) {
		this.prix = prix;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return code + " -> "+ designation +" ("+ prix+") ";
	}
	
	
	
	
}
