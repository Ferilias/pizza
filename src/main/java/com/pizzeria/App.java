package com.pizzeria;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		// initialisation des variables.
		int choix = 1;
		int tailleTableau = 8;
		// fin init
		Scanner sc = new Scanner(System.in);

		/**
		 * Menu d'administration de la pizzeria, qui permet de créer, modifier supprimer
		 * et afficher la liste des pizzas.
		 */

		Pizza[] pizzas = new Pizza[tailleTableau];
		pizzas[0] = new Pizza("PEP", "Pépéroni", 12.50);
		pizzas[1] = new Pizza("MAR", "Margherita", 14.00);
		pizzas[2] = new Pizza("REIN", "La Reine", 11.50);
		pizzas[3] = new Pizza("FRO", "La 4 Fromages", 11.50);
		pizzas[4] = new Pizza("CAN", "La cannobale", 12.50);
		pizzas[5] = new Pizza("SAV", "La savoyarde", 13.00);
		pizzas[6] = new Pizza("ORI", "L'Orientale", 13.50);
		pizzas[7] = new Pizza("IND", "L'indienne", 14.00);

		/**
		 * Boucle de choix Choix 1 à 4 1 Liste les pizzas 2 Ajout d'une pizza 3 mettre à
		 * jour une pizza 4 Supprimer une pizza 99 Sortir de la boucle
		 */

		while (choix >= 1 && choix <= 4) {
			System.out.println(Pizza.settingMenu());
			choix = sc.nextInt();

			if (choix == 1) {
				System.out.println("Liste des pizzas");
				for (Pizza pizza : pizzas) {
					System.out.println(pizza.toString());
				}
			}

			else if (choix == 2) {
				if (tailleTableau == pizzas.length) {
					tailleTableau++;
					Pizza[] tmps = new Pizza[tailleTableau];
					for (int i = 0; i < pizzas.length; i++) {
						tmps[i] = pizzas[i];
					}
					pizzas = tmps;
				}
				System.out.println("Ajout d'une nouvelle pizza");
				System.out.println("Veuillez saisir le code : ");
				sc.nextLine();
				String code = sc.nextLine();
				System.out.println("Veuillez saisir le nom : ");
				String nom = sc.nextLine();
				System.out.println("Veuillez saisir le prix : ");
				int prix = sc.nextInt();
				pizzas[pizzas.length - 1] = new Pizza(code, nom, prix);

			}

			else if (choix == 3) {
				System.out.println("Mise à jour d'une pizza");
				System.out.println("Veuillez saisir le code de la pizza à modifier.");
				sc.nextLine();
				String code = sc.nextLine();
				System.out.println("Veuillez saisir le nouveau code");
				String newcode = sc.nextLine();
				System.out.println("Veuillez saidir le nouveau nom");
				String nom = sc.nextLine();
				System.out.println("Veuillez saidir le nouveau prix");
				double prix = sc.nextDouble();
				sc.nextLine();
				for (Pizza pizza : pizzas) {
					if (code.equals(pizza.getCode())) {
						pizza.setCode(newcode);
						pizza.setDesignation(nom);
						pizza.setPrix(prix);
					}
				}
			}

			else if (choix == 4) {
				System.out.println("Suppression d'une pizza");
				System.out.println("Veuillez saisir le code de la pizza à supprimer.");
				sc.nextLine();
				String code = sc.nextLine();

				int i = 0;

				tailleTableau--;
				Pizza[] tmps = new Pizza[tailleTableau];
				for (Pizza pizza : pizzas) {
					if (!code.equals(pizza.getCode())) {
						tmps[i] = pizza;
						i++;
					}
				}
				pizzas = tmps;

			}
		}
		sc.close();
	}
}
