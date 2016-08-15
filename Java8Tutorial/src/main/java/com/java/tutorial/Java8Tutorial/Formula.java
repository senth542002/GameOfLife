package com.java.tutorial.Java8Tutorial;

public interface Formula {

	default Double sqrt(int number){
		return Math.sqrt(number);
	}

	Double calculate(int value);

}