package com.pizzeria;

import com.pizzeria.Pizza;
import java.util.Comparator;

public class PrixComparator implements Comparator<Pizza> {

	public PrixComparator() {
		
	}

	public int compare(Pizza p1, Pizza p2) {
		
		int result = p2.getPrix().compareTo(p1.getPrix());
		return result;
		
	}
	
}
