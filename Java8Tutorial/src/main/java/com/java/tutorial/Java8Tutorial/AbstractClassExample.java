package com.java.tutorial.Java8Tutorial;

public abstract class AbstractClassExample {

	abstract int addition(int a, int b);
	
	 int subtraction(int a, int b){
		return a-b;
	}

	 int multiplication(int a, int b){
		return a*b;
	}
	 
	 public String stringConcatination(String a, String b){
		 return a.concat(" ").concat(b);
	 }
}