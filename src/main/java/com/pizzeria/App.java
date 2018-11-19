package com.pizzeria;
import java.util.Scanner;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	// initialisation des variables.
    	int choix = 1;
    	
    	// fin init
        Scanner sc = new Scanner(System.in);
        
        /**
         * Menu d'administration de la pizzeria, qui permet de créer, 
         * modifier supprimer et afficher la liste des pizzas.
         */
        while (choix >= 1 && choix <= 4) {
        	
        	System.out.println("***** Pizzeria Administration *****");
        	System.out.println("1. \t Lister les pizzas");
        	System.out.println("2. \t Ajouter une nouvelle pizza");
        	System.out.println("3. \t Mettre à jour une pizza");
        	System.out.println("4. \t Supprimer une pizza");
        	System.out.println("99. \t Sortir");
        choix = sc.nextInt();
        
        if (choix == 1) {
        	System.out.println("Liste des pizzas");
        	
        }
        
        else if (choix == 2) {
        	System.out.println("Ajout d'une nouvelle pizza");
        }
        
        else if (choix == 3) {
        	System.out.println("Mise à jour d'une pizza");
        }
        
        else if (choix == 4) {
        	System.out.println("Suppression d'une pizza");
        }
        
        
        
        }
    }
}
