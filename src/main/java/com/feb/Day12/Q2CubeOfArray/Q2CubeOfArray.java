package com.feb.Day12.Q2CubeOfArray;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.stream.IntStream;

import com.jan.commons.annotations.PickClassForExecution;
import com.jan.commons.annotations.PickMethodForExecution;
import com.utils.BaseClass;
@PickClassForExecution
public class Q2CubeOfArray extends BaseClass {

	private ArrayList<Integer> input = new ArrayList<>();
	@Override
	@PickMethodForExecution
	public void solve() {
		populateData();
		ArrayList<Long> response = new ArrayList<>();
		IntStream.range(0, input.size()).forEach(index->{
			response.add(Long.valueOf(Double.valueOf(Math.pow(input.get(index), 3)).longValue()));
		});
		getLog().info("Q2 Generated Output: {}", response);
	}

	@Override
	public void populateData() {
		int sizeOfInput = 3; //rnd.nextInt(Double.valueOf(Math.pow(10, 6)).intValue());
		IntStream.range(0, sizeOfInput).forEach(index->input.add( rnd.nextInt(Double.valueOf(Math.pow(10, 6)).intValue())));
		getLog().info("Q2 Generated Input: {}", input);
	}

}
