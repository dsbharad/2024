package com.feb.streams.set1.Q1AverageOfIntegers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.IntStream.Builder;

import com.jan.commons.annotations.PickClassForExecution;
import com.jan.commons.annotations.PickMethodForExecution;
import com.utils.BaseClass;
import com.utils.data_generator.NumericDataGenerator;
@PickClassForExecution
public class AverageOfIntegerList extends BaseClass {
	
	private List<Integer> input = new ArrayList<>();

	@Override
	@PickMethodForExecution
	public void solve() {
		populateData();
		long beginTime = System.currentTimeMillis();
		getLog().info("P1 AverageOfIntegers: Started Execution at {} millis", beginTime);
		Builder builder = IntStream.builder();
		input.stream().forEach(builder::add);
		Double average = builder.build().average().orElse(0.0);
		getLog().info("P1 AverageOfIntegers: Generated Output: {}", average);
		getLog().info("P1 AverageOfIntegers: Completed Execution in {} millis", System.currentTimeMillis()-beginTime);
		
		//FollowingSequenceTakesMoreTimeToComplete
		getLog().info("P1 AverageOfIntegers: Started Execution at {} millis", beginTime);
		double avg = input.stream().mapToDouble(Integer::doubleValue).average().orElse(0.0);
		getLog().info("P1 AverageOfIntegers: Generated Output: {}", avg);
		getLog().info("P1 AverageOfIntegers: Completed Execution in {} millis", System.currentTimeMillis()-beginTime);
	
	}

	@Override
	public void populateData() {
		input = NumericDataGenerator.getRandomListOfInteger();
		getLog().info("P1 AverageOfIntegers: DataSize: {} and Generated Input: {}",input.size(), input);

	}

}
