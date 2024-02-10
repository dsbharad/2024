package com.feb.streams.set1.Q5CountOfStringsStartingWithGivenChar;

import java.util.List;
import java.util.stream.Collectors;

import com.jan.commons.annotations.PickClassForExecution;
import com.jan.commons.annotations.PickMethodForExecution;
import com.utils.BaseClass;
import com.utils.data_generator.StringDataGenerator;
@PickClassForExecution
public class Q5CountOfStringsStartingWithGivenChar extends BaseClass {

	private List<String> input;
	@Override
	@PickMethodForExecution
	public void solve() {
		populateData();
		String ref = "A";
		List<String> filteredList = input.stream()
			.filter(item->item.toUpperCase().startsWith(ref))
			.collect(Collectors.toList());
		getLog().info("P5 CountOfStringsBeginningWith: sizeOfOutput: {}; Generated Output: {}",filteredList.size(), filteredList);
	}

	@Override
	public void populateData() {
		input = StringDataGenerator.getRandomListOfString();
		getLog().info("P5 CountOfStringsBeginningWith: DataSize: {} and Generated Input: {}",input.size(), input);

	}

}
