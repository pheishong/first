package com.cy.factory;

public class BeanTests {

	private static Dog dog = BeanFactory.getBean("dog");
	private static Cat cat = BeanFactory.getBean("cat");
	
	public static void main(String[] args) {
		dog.sleep();
		cat.eat();
		
	}
}
