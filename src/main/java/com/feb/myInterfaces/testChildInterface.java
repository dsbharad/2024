package com.feb.myInterfaces;

import java.util.Scanner;

public interface testChildInterface extends testInterface {
	
	@Override
	default void defaultMethod() {
		
		int[] arr = new int[5];
		System.out.println(arr.length);
		Scanner scr = new Scanner(System.in);
		throw new RuntimeException("NotSupported");
	}

}
