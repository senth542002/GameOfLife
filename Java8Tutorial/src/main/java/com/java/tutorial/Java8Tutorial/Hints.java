package com.java.tutorial.Java8Tutorial;

import java.lang.annotation.Repeatable;

public @interface Hints {
	Hint[] value();

}

@Repeatable(Hints.class)
@interface Hint{
	String value();
}
