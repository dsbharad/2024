package com.feb.streams.set1.Q2CaseConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.Stream.Builder;

import com.jan.commons.annotations.PickClassForExecution;
import com.jan.commons.annotations.PickMethodForExecution;
import com.utils.BaseClass;
import com.utils.data_generator.StringDataGenerator;
@PickClassForExecution
public class CaseConverter extends BaseClass {

	private List<String> input ;
	@Override
	@PickMethodForExecution
	public void solve() {
		populateData();
	}

	@Override
	public void populateData() {
		input = StringDataGenerator.getRandomListOfString();
		long beginTime = System.currentTimeMillis();
		getLog().info("P2 CaseConverter: Started Execution at {} millis", beginTime);
		getLog().info("P2 CaseConverter: sizeOfInput:{}; generated Input: {}", input.size(), input);
		Builder<String> builder = Stream.builder();
		input.stream().forEach(builder::add);
		Stream<String> inputStream = builder.build();
		ArrayList<String> upperCasedList = inputStream.map(String::toUpperCase).collect(Collectors.toCollection(ArrayList<String>::new));
		getLog().info("P2 CaseConverter: upperCasedOutput: {}", upperCasedList);
		ArrayList<String> lowerCasedList = upperCasedList.stream().map(String::toLowerCase).collect(Collectors.toCollection(ArrayList<String>::new));
		getLog().info("P2 CaseConverter: lowerCasedOutput: {}", lowerCasedList);
		getLog().info("P2 CaseConverter: Completed Execution in {} millis", System.currentTimeMillis()-beginTime);

	}

}
