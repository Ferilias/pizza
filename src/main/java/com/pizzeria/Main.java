package com.pizzeria;

import java.util.Scanner;
import com.pizzeria.Pizza;

/**
 * Hello world!
 *
 */
public class Main {
	public static void main(String[] args) {

		PizzaMemDao dao = new PizzaMemDao();
		
		Scanner sc = new Scanner(System.in);
		int choix =1;
		
		
		while (choix >= 1 && choix <= 4) {
			
			System.out.println(Pizza.settingMenu());
			choix = sc.nextInt();

			if (choix == 1) {
				dao.findAllPizzas();;	}
		
			
			else if (choix == 2) {
				System.out.println("Ajout d'une nouvelle pizza");
				System.out.println("Veuillez saisir le code : ");
				sc.nextLine();
				String code = sc.nextLine();
				System.out.println("Veuillez saisir le nom : ");
				String nom = sc.nextLine();
				System.out.println("Veuillez saisir le prix : ");
				int prix = sc.nextInt();
				dao.addPizza(new Pizza(code, nom, prix));
			}

			else if (choix == 3) {
				System.out.println("Mise à jour d'une pizza");
				System.out.println("Veuillez saisir le code de la pizza à modifier.");
				sc.nextLine();
				String code = sc.nextLine();
				System.err.println(code);
				System.out.println("Veuillez saisir le nouveau code");
				String newcode = sc.nextLine();
				System.err.println(newcode);
				System.out.println("Veuillez saidir le nouveau nom");
				String nom = sc.nextLine();
				System.err.println(nom);
				System.out.println("Veuillez saidir le nouveau prix");
				double prix = sc.nextDouble();
				System.err.println(prix);
				sc.nextLine();				
				Pizza PizzaAUpdate = new Pizza (newcode, nom, prix);
				dao.updatePizza(code, PizzaAUpdate);
					}
			
			else if (choix == 4) {
				System.out.println("Suppression d'une pizza");
				System.out.println("Veuillez saisir le code de la pizza à supprimer.");
				sc.nextLine();
				String code = sc.nextLine();
				dao.deletePizza(code);
			}
		}
		dao.findAllPizzas();
		sc.close();
	}
}
