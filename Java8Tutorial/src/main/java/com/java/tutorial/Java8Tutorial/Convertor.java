package com.java.tutorial.Java8Tutorial;

@FunctionalInterface
public interface Convertor<T,F> {
	T convert(F from);
}