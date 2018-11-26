package com.pizzeria;

import com.pizzeria.Pizza;

import java.util.Comparator;

public class CodeComparator implements Comparator<Pizza> {
	
	public CodeComparator() {
			
		}
			
	public int compare (Pizza p1, Pizza p2) {
		int result = p1.getCode().compareTo(p2.getCode());
		return result;
		}
}


