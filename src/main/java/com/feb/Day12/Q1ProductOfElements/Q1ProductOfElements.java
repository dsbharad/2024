package com.feb.Day12.Q1ProductOfElements;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalLong;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.jan.commons.annotations.PickClassForExecution;
import com.jan.commons.annotations.PickMethodForExecution;
import com.utils.BaseClass;
import com.utils.NumericConstants;
@PickClassForExecution
public class Q1ProductOfElements extends BaseClass {
	private long response = 1;
	private ArrayList<Integer> input = new ArrayList<>();
	private ArrayList<Long> output = new ArrayList<>();
	@Override
	@PickMethodForExecution
	public void solve() {
		populateData();
		input.stream().mapToLong(Long::valueOf).forEach(this::updateResponse);
		getLog().info("Q1 Generated output: {}", response);
	}

	private Object updateResponse(long val) {
		response = response * val;
		return null;
	}

	@Override
	public void populateData() {
		int sizeOfInput = 3; //rnd.nextInt(Double.valueOf(Math.pow(10, 6)).intValue());
		IntStream.range(0, sizeOfInput).forEach(index->input.add( rnd.nextInt(NumericConstants.INT_HUNDRED)));
		getLog().info("Q1 Generated Input: {}", input);
		
	}
	
	public ArrayList<ArrayList<Integer>> solve(int rowSize) {
        ArrayList<ArrayList<Integer>> response = new ArrayList<>();
        response=IntStream.range(0, rowSize).mapToObj(row->{
            return IntStream.range(0,row).collect(ArrayList<Integer>::new, ArrayList<Integer>::add, ArrayList<Integer>::addAll);
        }).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		IntStream.range(0, rowSize).mapToObj(i -> {
			return IntStream.range(0, i).collect(ArrayList::new,ArrayList::add,ArrayList::addAll);
		}).collect(ArrayList::new,ArrayList::add,ArrayList::addAll);
        
        return response;
    }

}
