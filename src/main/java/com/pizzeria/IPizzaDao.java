package com.pizzeria;

public interface IPizzaDao {
	
	Pizza[] findAllPizzas();
	
	void updatePizza(String codePizza, Pizza pizzaAupdate);
	
	Pizza findPizzaByCode(String codePizza);
	
	boolean isPizzaExists(String codePizza);
	
	void addPizza(Pizza pizza);
	
	void deletePizza(String codePizza);
	
}
