package com.feb.temp;

import java.util.Scanner;

public class TempMain {
	public static void main(String[] args) {
		// YOUR CODE GOES HERE
		// Please take input and print output to standard input/output (stdin/stdout)
		// DO NOT USE ARGUMENTS FOR INPUTS
		// E.g. 'Scanner' for input & 'System.out' for output
//		Scanner scr = new Scanner(System.in);
//		// String lineInput = scr.nextLine();
//		int countOfTestCases = scr.nextInt();
//		while (countOfTestCases > 0) {
//			solve(scr);
//			countOfTestCases--;
//		}
		Scanner scr = new Scanner(System.in);
        int size = scr.nextInt();
        int[] inputArray = new int[size+1];
        String lineInput = scr.nextLine();
        String[] inputStrArray = lineInput.split(" ");
        int position = 0;
        int newValue = 0;
        size = inputStrArray.length;
        for(int index = 0; index<size; index++){
            inputArray[index] = Integer.valueOf(inputStrArray[index]);
        }
        lineInput = scr.nextLine();
        lineInput = lineInput.replace(" ", "");
        position = Integer.valueOf(lineInput);
        lineInput = scr.next();
        lineInput = lineInput.replace(" ", "");
        newValue = Integer.valueOf(lineInput);
        for(int index= size-1; index>position; index--){
            inputArray[index+1] = inputArray[index];
        }
        inputArray[position] = newValue;
        for(int index = 0; index<size+1; index++){
            System.out.print(inputArray[index]);
        }

	}

	private static void solve(Scanner scr) {
		int sizeOfInput = scr.nextInt();
		String lineInput = scr.nextLine();
		lineInput = lineInput.trim();
		String[] strArray = lineInput.split(" ");
//	        int[] inputNumArray = new int[strArray.length];
		String evenResponse = "";
		String oddResponse = "";
		for (int index = 0; index < strArray.length; index++) {
			int num;
			if (!strArray[index].trim().isEmpty()) {
				num = Integer.valueOf(strArray[index]);
				if (num % 2 == 0) {
					evenResponse = evenResponse + strArray[index] + " ";
				} else {
					oddResponse = oddResponse + strArray[index] + " ";
				}
			}
		}
		System.out.println(oddResponse);
		System.out.println(evenResponse);
	}
}
