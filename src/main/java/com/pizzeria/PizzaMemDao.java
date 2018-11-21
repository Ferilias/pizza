package com.pizzeria;

public class PizzaMemDao implements IPizzaDao {

	
	
		
	static Pizza[] pizzas = new Pizza[8];
	{	
	pizzas[0] = new Pizza("PEP", "Pépéroni", 12.50);
	pizzas[1] = new Pizza("MAR", "Margherita", 14.00);
	pizzas[2] = new Pizza("REIN", "La Reine", 11.50);
	pizzas[3] = new Pizza("FRO", "La 4 Fromages", 11.50);
	pizzas[4] = new Pizza("CAN", "La cannobale", 12.50);
	pizzas[5] = new Pizza("SAV", "La savoyarde", 13.00);
	pizzas[6] = new Pizza("ORI", "L'Orientale", 13.50);
	pizzas[7] = new Pizza("IND", "L'indienne", 14.00);
	
}
	public Pizza[] findAllPizzas() {
		for (Pizza pizza : pizzas) {
			System.out.println(pizza.toString());
		}	return pizzas;
	}

	public void updatePizza(String codePizza, Pizza pizzaAupdate) {
		for (int i =0; i < pizzas.length;i++) {
			if (codePizza.equals(pizzas[i].getCode())) {
				pizzas[i] = pizzaAupdate;
			}
			}
	}
	

	public Pizza findPizzaByCode(String codePizza) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isPizzaExists(String codePizza) {
		// TODO Auto-generated method stub
		return false;
	}

	public void addPizza(Pizza pizza) {
		Pizza[] tmps = new Pizza[pizzas.length +1];
		for (int i = 0; i < pizzas.length; i++) {
			tmps[i] = pizzas[i];
		}
		tmps[tmps.length-1] = pizza;
		pizzas = tmps;		
	}
	

	public void deletePizza(String codePizza) {
		int i = 0;
		Pizza[] tmps = new Pizza[pizzas.length - 1];
		for (Pizza pizza : pizzas) {
			if (!codePizza.equals(pizza.getCode())) {
				tmps[i] = pizza;
				i++;
			}
		}
		pizzas = tmps;
		}		
}

