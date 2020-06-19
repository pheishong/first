package com.cy.lambda;

public class DemoCook {

	public static void main(String[] args) {
		invokeCook(()->{
			System.out.println("大厨在炒麻辣小龙虾");
		});
		
		
	}
	
	public static void invokeCook(Cook cook) {
		cook.makeFood();
	}
}
