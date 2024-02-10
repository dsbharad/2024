package com.feb.streams.set1.Q6StringSorting;

import java.util.List;
import java.util.stream.Collectors;

import com.jan.commons.annotations.PickClassForExecution;
import com.jan.commons.annotations.PickMethodForExecution;
import com.utils.BaseClass;
import com.utils.data_generator.StringDataGenerator;

@PickClassForExecution
public class Q6StringSorting extends BaseClass {
	private List<String> input;

	@Override
	@PickMethodForExecution
	public void solve() {
		populateData();
		getLog().info("P6 StringSorting: NaturalOrder: generated output: {}",
				input.stream().sorted().collect(Collectors.toList()));
		getLog().info("P6 StringSorting: DescendingOrder: generated output: {}",
				input.stream().sorted((a,b)->b.compareTo(a)).collect(Collectors.toList()));
//		input.stream().sorted((a,b)->a.charAt(2)<= b.charAt(2)?1:0);
	}

	@Override
	public void populateData() {
		input = StringDataGenerator.getRandomListOfString();
		getLog().info("P6 StringSorting: sizeOfInput: {}; generated input: {}", input.size(), input);
	}

}
