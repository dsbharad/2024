package com.feb.lambdas;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LambdaLearning {
	public static void main1(String[] args) {
		// YOUR CODE GOES HERE
		// Please take input and print output to standard input/output (stdin/stdout)
		// DO NOT USE ARGUMENTS FOR INPUTS
		// E.g. 'Scanner' for input & 'System.out' for output
		Scanner scr = new Scanner(System.in);
		String lineInput = "10 50 40 80";//scr.nextLine();
		String[] inputStrArray = lineInput.split(" ");
		int[] inputArray = new int[inputStrArray.length];
		int response = 0;
		for (int index = 1; index < inputStrArray.length; index++) {
			inputArray[index] = Integer.valueOf(inputStrArray[index]);
			response += inputArray[index];
		}
		/*
		 * 1. convert arrays to collection. Collection will be converted as stream.
		 * 2. mapToInt -- iterating over each element in the stream of strings, each string item is converted to int and so, we get stream of integers
		 * 3. body of function is used for step#2 is Intger.valueOf()
		 * 4. sum -- inbuilt in intStream to sum all of the elements
		 */
		response = Arrays.asList(inputStrArray).stream().mapToInt(item-> Integer.valueOf(item)).sum();
//		Arrays.asList(inputStrArray).stream().mapToInt(item-> Integer.valueOf(item)).collect(Collectors.summingInt());
		OptionalInt reduce = Stream.of(inputStrArray).mapToInt(item-> Integer.valueOf(item)).reduce((a,b)->a*3);
		Optional<String> reduce2 = Stream.of(inputStrArray).reduce((a,b)->a+b);
		int val = reduce.isPresent() ? reduce.getAsInt() : 0;
		System.out.print(response+ " *** " + val +" *** " + reduce2.get());
		
	}
	public static void main2(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output

        Scanner scr = new Scanner(System.in);
        String lineInput = scr.nextLine();
        String[] inputStrArray = lineInput.split(" ");
        
        IntStream intStreamInput = Stream.of(inputStrArray).mapToInt(item->Integer.valueOf(item));
        OptionalInt maxOfInput = intStreamInput.max();
        OptionalInt minOfInput = intStreamInput.min();
        
        System.out.print(maxOfInput + " " + minOfInput);
    }

}
