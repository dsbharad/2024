package com.feb.myInterfaces;

public class MyConcreteClass extends MyAbstractClass {
	
	@Override
	public void defaultMethod() {
		this.data = "Hello";
		System.out.println("Overridden method in concrete class" + this.data);
		super.defaultMethod();
	}
}
