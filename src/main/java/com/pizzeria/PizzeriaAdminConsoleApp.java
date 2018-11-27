package com.pizzeria;

import java.util.Collections;
import java.util.Scanner;

import com.pizzeria.Pizza;
import com.pizzeria.CodeComparator;
import com.pizzeria.PrixComparator;

import exception.DeletePizzaException;
import exception.SavePizzaException;
import exception.UpdatePizzaException;
import model.CategoriePizzaEnum;


public class PizzeriaAdminConsoleApp {
	
	public static void main(String[] args) {
		
		boolean enter = true;
		PizzaMemDao dao = new PizzaMemDao();
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez trier la liste");
		int choix = sc.nextInt();
		
		if (choix == 1) {
			
			Collections.sort(dao.findAllPizzas(),new CodeComparator());
		}
		
		else {
			Collections.sort(dao.findAllPizzas(),new PrixComparator());
		}
		dao.findAllPizzas();
		
		while (enter) {
			
			System.out.println(Pizza.settingMenu());
			choix = sc.nextInt();

			if (choix == 1) {
				dao.findAllPizzas();	
				}
		
			
			else if (choix == 2) {
				System.out.println("Ajout d'une nouvelle pizza");
				System.out.println("Veuillez saisir le code : ");
				sc.nextLine();
				String code = sc.nextLine();
				System.out.println("Veuillez saisir le nom : ");
				String nom = sc.nextLine();
				System.out.println("Veuillez saisir le prix : ");
				int prix = sc.nextInt();
				sc.nextLine();
				System.out.println(CategoriePizzaEnum.toStringAll());
				System.out.println("Veuillez saisir la catégorie");
				String cat = sc.nextLine().toUpperCase();
				try {
					dao.addPizza(new Pizza(code, nom, prix, CategoriePizzaEnum.valueOf(cat)));
				} catch (SavePizzaException e) {
					System.out.println(e.getMessage());
				}
			}

			else if (choix == 3) {
				System.out.println("Mise à jour d'une pizza");
				System.out.println("Veuillez saisir le code de la pizza à modifier.");
				sc.nextLine();
				String code = sc.nextLine();
				System.out.println("Veuillez saisir le nouveau code");
				String newcode = sc.nextLine();
				System.out.println("Veuillez saisir le nouveau nom");
				String nom = sc.nextLine();
				System.out.println("Veuillez saisir le nouveau prix");
				double prix = sc.nextDouble();
				sc.nextLine();	
				System.out.println(CategoriePizzaEnum.toStringAll());
				System.out.println("Veuillez saisir la catégorie");
				String cat = sc.nextLine().toUpperCase();
				Pizza PizzaAUpdate = new Pizza (newcode, nom, prix, CategoriePizzaEnum.valueOf(cat));
				try {
					dao.updatePizza(code, PizzaAUpdate);
				} catch (UpdatePizzaException e) {
					System.out.println(e.getMessage());					
				}
					}
			
			else if (choix == 4) {
				System.out.println("Suppression d'une pizza");
				System.out.println("Veuillez saisir le code de la pizza à supprimer.");
				sc.nextLine();
				String code = sc.nextLine();
				try {
					dao.deletePizza(code);
				} catch (DeletePizzaException e) {
					System.out.println(e.getMessage());
				}
			}
			else if (choix == 99) {
				enter = false;
			}
		}
		dao.findAllPizzas();
		sc.close();
	}
}
