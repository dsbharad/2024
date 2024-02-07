package com.jan;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	      System.out.println("Hello, World!");
	      Scanner scr = new Scanner(System.in);
	      int input = scr.nextInt();
	      boolean isEven = false;
	      isEven = checkAndRespond(input);
	      System.out.println(isEven);
	  }
	  private static boolean checkAndRespond(int input){
	    return (input%2 == 0);
	  }
}