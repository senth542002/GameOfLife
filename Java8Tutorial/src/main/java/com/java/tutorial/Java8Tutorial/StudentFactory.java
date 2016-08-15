package com.java.tutorial.Java8Tutorial;

public interface StudentFactory<S extends Student> {
	S create(String firstName, String lastName);
}
