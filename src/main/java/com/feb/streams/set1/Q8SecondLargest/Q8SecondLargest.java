package com.feb.streams.set1.Q8SecondLargest;

import java.util.List;
import java.util.stream.Collectors;

import com.jan.commons.annotations.PickClassForExecution;
import com.jan.commons.annotations.PickMethodForExecution;
import com.utils.BaseClass;
import com.utils.data_generator.NumericDataGenerator;
@PickClassForExecution
public class Q8SecondLargest extends BaseClass {

	private List<Integer> input;
	@Override
	@PickMethodForExecution
	public void solve() {
		populateData();
		Integer secondLargest = input.stream().distinct().sorted((a,b)->b.compareTo(a)).skip(1).findFirst().orElse(null);
		getLog().info("P8 SecondLargest: generatedOutput: {}", secondLargest);
	}

	@Override
	public void populateData() {
		input = NumericDataGenerator.getRandomListOfInteger();
		getLog().info("P8 SecondLargest: sizeOfInput: {} generatedInput: {}", input.size(), input);
	}

}
