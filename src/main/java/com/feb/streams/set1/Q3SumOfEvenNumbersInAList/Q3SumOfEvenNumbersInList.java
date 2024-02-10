package com.feb.streams.set1.Q3SumOfEvenNumbersInAList;

import java.util.List;
import java.util.Optional;

import com.jan.commons.annotations.PickClassForExecution;
import com.jan.commons.annotations.PickMethodForExecution;
import com.utils.BaseClass;
import com.utils.data_generator.NumericDataGenerator;

@PickClassForExecution
public class Q3SumOfEvenNumbersInList extends BaseClass {

	private List<Integer> input;

	@Override
	@PickMethodForExecution
	public void solve() {
		populateData();
		long beginTime = System.currentTimeMillis();
		getLog().info("P3 SumOfEvenIntegers: Started Execution at {} millis", beginTime);
		Integer evenSum = input.stream().filter(item->item%2==0).reduce((a,b)->a+b).orElse(0);
		getLog().info("P3 SumOfEvenIntegers: SumOfEvenIntegers: {}", evenSum);
		Integer oddSum = input.stream().filter(item->item%2==1).reduce((a,b)->a+b).orElse(0);
		getLog().info("P3 SumOfEvenIntegers: SumOfEvenIntegers: {}", oddSum);
		getLog().info("P3 SumOfEvenIntegers: Completed Execution in {} millis", System.currentTimeMillis()-beginTime);
		
	}

	@Override
	public void populateData() {
		input = NumericDataGenerator.getRandomListOfInteger();
		getLog().info("P3 SumOfEvenIntegers: DataSize: {} and Generated Input: {}",input.size(), input);
	}

}
