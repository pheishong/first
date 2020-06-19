package com.cy.lambda;

public class DemoCalculator {

	public static void main(String[] args) {
		
//		invokeCalc(100,20,(int a,int b)->{
//			return a-b;
//		});
		
		//==================================
		
		//优化写法
		invokeCalc(100,20,(a, b)->a*b);
		
	}
	public static void invokeCalc(int a,int b ,Calculator c) {
		int sum = c.calc(a, b);
		System.out.println(sum);
	}
}
