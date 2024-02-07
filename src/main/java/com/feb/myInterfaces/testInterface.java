package com.feb.myInterfaces;

import java.util.Arrays;
import java.util.List;

public interface testInterface {
	List<String> allowedColors = Arrays.asList("RED", "GREEN", "BLUE");
	public Integer variable = 2;
	public int val1 = 0;
	public void instanceMethod1();
	public static void classMethod1() {
		System.out.println("Method body defined in interface");
	};
	public default void defaultMethod() {
		
		System.out.println("This is default implementation provided in interface" + this.val1);
	}
	
	
	
}
