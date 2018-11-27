package com.pizzeria;
import java.util.*;

import com.pizzeria.Pizza;
import exception.DeletePizzaException;
import exception.SavePizzaException;
import exception.StockageException;
import exception.UpdatePizzaException;
import model.CategoriePizzaEnum;

public class PizzaMemDao implements IPizzaDao {

	
	List<Pizza> pizzas = new ArrayList<Pizza>();
	
	{
	pizzas.add(new Pizza("PEP", "Pépéroni", 12.50, CategoriePizzaEnum.FROMAGE));
	pizzas.add(new Pizza("MAR", "Margherita", 14.00, CategoriePizzaEnum.FROMAGE));
	pizzas.add(new Pizza("REIN", "La Reine", 11.50, CategoriePizzaEnum.FROMAGE));
	pizzas.add(new Pizza("FRO", "La 4 Fromages", 11.50, CategoriePizzaEnum.FROMAGE));
	pizzas.add(new Pizza("CAN", "La cannibale", 12.50, CategoriePizzaEnum.VIANDE));
	pizzas.add(new Pizza("SAV", "La savoyarde", 13.00, CategoriePizzaEnum.VIANDE));
	pizzas.add(new Pizza("ORI", "L'Orientale", 13.50,CategoriePizzaEnum.AUTRE));
	pizzas.add(new Pizza("IND", "L'indienne", 14.00, CategoriePizzaEnum.VIANDE));
	}

	public List<Pizza> findAllPizzas() {
		for (Pizza pizza : pizzas) {
			System.out.println(pizza);
		}
		return pizzas;
	}

	public void updatePizza(String codePizza, Pizza pizzaAupdate) throws UpdatePizzaException {
		boolean isOk = false;
		try {
			pizzaAupdate.dataControl();
			isOk = true;
		}
		catch (StockageException e) {
			throw new UpdatePizzaException(e.getMessage());
		}
		
		if (isOk) {
		Pizza pizzaUpdate = findPizzaByCode(codePizza);
			pizzaUpdate.setCode(pizzaAupdate.getCode());
			pizzaUpdate.setDesignation(pizzaAupdate.getDesignation());
			pizzaUpdate.setPrix(pizzaAupdate.getPrix());
			pizzaUpdate.setCategorie(pizzaAupdate.getCategorie());
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
		boolean isOk = false;
		try {
			pizza.dataControl();
			isOk = true;
		}
		catch (StockageException e) {
			throw new SavePizzaException(e.getMessage());
		}
		
		if (isOk) {
		pizzas.add(pizza);
	}
	}

	public void deletePizza(String codePizza) throws DeletePizzaException{
		boolean isOk = false;
		try {
			findPizzaByCode(codePizza).dataControl();
			isOk = true;
		}
		catch (StockageException e) {
			throw new DeletePizzaException(e.getMessage());
		}
		if (isPizzaExists(codePizza) && isOk) {
		pizzas.remove(findPizzaByCode(codePizza));
		}
		else {
			System.out.println("La pizza n'existe pas");
		}
		}
	}

