package com.utils.data_generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import com.utils.NumericConstants;

public final class NumericDataGenerator {
	
	private static final Random rnd = new Random();
	
	private NumericDataGenerator() {
		
	}
	public static List<Integer> getRandomListOfInteger(){
		int sizeOfData = rnd.nextInt(NumericConstants.INT_TEN)+1;
		List<Integer> response = new ArrayList<>();
		response.addAll(IntStream.range(0, sizeOfData)
			.map(index -> rnd.nextInt(NumericConstants.INT_TEN) + 1)
			.collect(ArrayList<Integer>::new, ArrayList<Integer>::add, ArrayList<Integer>::addAll));
		return response;
	}
}
