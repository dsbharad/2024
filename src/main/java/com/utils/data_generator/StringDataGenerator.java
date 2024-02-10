package com.utils.data_generator;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.Stream.Builder;

import com.utils.NumericConstants;

public final class StringDataGenerator {
	private static final Random rnd = new Random();
	
	private StringDataGenerator() {
	}
	
	public static final List<String> getRandomListOfString(){
		List<String> response;
		Builder<String> builder = Stream.builder();
		int sizeOfData = rnd.nextInt(NumericConstants.INT_TEN)+1;
		for(int count = 0; count<sizeOfData; count++) {
			builder.add(UUID.randomUUID().toString().replace("-",""));
		}
		response = builder.build().collect(Collectors.toList());
		return response;
	}
	

}
