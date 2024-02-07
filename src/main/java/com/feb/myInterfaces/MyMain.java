package com.feb.myInterfaces;

public class MyMain {

	public static void main(String[] args) {
		MyConcreteClass mcc = new MyConcreteClass();
		testInterface.classMethod1();
		mcc.defaultMethod();
		
		MySecondGenClass msgc = new MySecondGenClass();
		msgc.defaultMethod();
	}

}
