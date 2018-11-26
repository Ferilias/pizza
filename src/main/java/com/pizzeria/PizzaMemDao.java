package com.pizzeria;
import java.util.*;

import exception.DeletePizzaException;
import exception.SavePizzaException;
import exception.UpdatePizzaException;

public class PizzaMemDao implements IPizzaDao {

	
	List<Pizza> pizzas = new ArrayList<Pizza>();
	
	{
	pizzas.add(new Pizza("PEP", "Pépéroni", 12.50));
	pizzas.add(new Pizza("MAR", "Margherita", 14.00));
	pizzas.add(new Pizza("REIN", "La Reine", 11.50));
	pizzas.add(new Pizza("FRO", "La 4 Fromages", 11.50));
	pizzas.add(new Pizza("CAN", "La cannobale", 12.50));
	pizzas.add(new Pizza("SAV", "La savoyarde", 13.00));
	pizzas.add(new Pizza("ORI", "L'Orientale", 13.50));
	pizzas.add(new Pizza("IND", "L'indienne", 14.00));
	}

	public List<Pizza> findAllPizzas() {
		for (Pizza pizza : pizzas) {
			System.out.println(pizza);
		}
		return pizzas;
	}

	public void updatePizza(String codePizza, Pizza pizzaAupdate) throws UpdatePizzaException {
		boolean exist = isPizzaExists(codePizza);
		if (exist == false) {
			throw new UpdatePizzaException("La pizza n'existe pas, impossible de la modifier");
			}
		Pizza pizzaUpdate = findPizzaByCode(codePizza);
		if(pizzaUpdate != null) {
			pizzaUpdate.setCode(pizzaAupdate.getCode());
			pizzaUpdate.setDesignation(pizzaAupdate.getDesignation());
			pizzaUpdate.setPrix(pizzaAupdate.getPrix());
		}
		else {
;
		}
		
	}
	public Pizza findPizzaByCode(String codePizza) {
		Pizza goodPizza = null;
		for (Pizza pizza : pizzas) {
			if(codePizza.equals(pizza.getCode())) {
				goodPizza = pizza;
			}
		}
		return goodPizza;
	}

	public boolean isPizzaExists(String codePizza) {
		return findPizzaByCode(codePizza)!=null;
	}

	public void addPizza(Pizza pizza) throws SavePizzaException{
		if (pizza.getCode().length() > 4) {
			throw new SavePizzaException("Le code contient plus de 4 lettres");
		}
		else {
		pizzas.add(pizza);
	}
	}

	public void deletePizza(String codePizza) throws DeletePizzaException{
		boolean exist = isPizzaExists(codePizza);
		if (exist == false) {
			throw new DeletePizzaException("La pizza n'existe pas, impossible de la supprimer");
			}
		pizzas.remove(findPizzaByCode(codePizza));
		}
	
}

