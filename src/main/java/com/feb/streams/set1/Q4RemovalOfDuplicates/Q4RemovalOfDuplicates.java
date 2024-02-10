package com.feb.streams.set1.Q4RemovalOfDuplicates;

import java.util.List;
import java.util.stream.Stream;

import com.jan.commons.annotations.PickClassForExecution;
import com.jan.commons.annotations.PickMethodForExecution;
import com.utils.BaseClass;
import com.utils.data_generator.NumericDataGenerator;
@PickClassForExecution
public class Q4RemovalOfDuplicates extends BaseClass {
	private List<Integer> input;
	@Override
	@PickMethodForExecution
	public void solve() {
		populateData();
		Stream<Integer> uniqueStream = input.stream().distinct();
		getLog().info("P4 RemovalOfDuplicates: generated output: {}", uniqueStream.toList());
	}

	@Override
	public void populateData() {
		input = NumericDataGenerator.getRandomListOfInteger();
		getLog().info("P4 RemovalOfDuplicates: DataSize: {} and Generated Input: {}",input.size(), input);
	}

}
