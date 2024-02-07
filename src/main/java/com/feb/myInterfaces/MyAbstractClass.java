package com.feb.myInterfaces;

public abstract class MyAbstractClass implements testInterface {
	public String data = "Hello";
	public void instanceMethod1() {
		data = data + data;
		System.out.println("Instance method declared in abstract class");
	}
	public void myConcreteMethod() {
		System.out.println("Hello");
	}
}
