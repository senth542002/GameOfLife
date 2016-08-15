package com.java.tutorial.Java8Tutorial;

@FunctionalInterface
public interface FunctionalInterfaceExample {
	
	Integer addition(Integer a, Integer b);
	
	default Integer subtraction(Integer a, Integer b){
		return a-b;
	}

	default Integer multiplication(Integer a, Integer b){
		return a*b;
	}
	
	//Double division(int a, int b);
}
