package com.feb.Day12.Q3FrequencyCount;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import com.jan.commons.annotations.PickClassForExecution;
import com.jan.commons.annotations.PickMethodForExecution;
import com.utils.BaseClass;
import com.utils.NumericConstants;

@PickClassForExecution
public class Q3FrequencyCount extends BaseClass {
	
	List<Integer> input = new ArrayList<>();

	@PickMethodForExecution
	@Override
	public void solve() {
		populateData();
		ArrayList<Integer> response = new ArrayList<>();
		IntStream.range(0,input.size()).forEach(index->{
			response.add((int) input.stream().filter(item->(item.compareTo(input.get(index)))==0).count());
			});
		getLog().info("Q3 Generated Output: {}", response);
	}

	@Override
	public void populateData() {
		int size= rnd.nextInt(NumericConstants.INT_THOUSAND)+1;
		while(size>0) {
			input.add(rnd.nextInt(NumericConstants.INT_HUNDRED)+1);
			size--;
		}
		getLog().info("Q3 Generated Input: {}", input);
	}

}
