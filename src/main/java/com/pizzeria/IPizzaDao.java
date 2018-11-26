package com.pizzeria;

import java.util.*;

import exception.DeletePizzaException;
import exception.SavePizzaException;
import exception.UpdatePizzaException;
public interface IPizzaDao {
	
	List<Pizza> findAllPizzas();
	
	void updatePizza(String codePizza, Pizza pizzaAupdate) throws UpdatePizzaException;
	
	Pizza findPizzaByCode(String codePizza);
	
	boolean isPizzaExists(String codePizza);
	
	void addPizza(Pizza pizza) throws SavePizzaException;
	
	void deletePizza(String codePizza) throws DeletePizzaException;
	
	
}
