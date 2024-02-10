package com.feb.Day12.Q5MainDiagonalSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import com.jan.commons.annotations.PickClassForExecution;
import com.jan.commons.annotations.PickMethodForExecution;
import com.utils.BaseClass;
import com.utils.NumericConstants;
@PickClassForExecution
public class Q5MainDiagonalSum extends BaseClass {
	
	private List<ArrayList<Integer>> input = new ArrayList<>();
	private int place=-1;

	@Override
	@PickMethodForExecution
	public void solve() {
		populateData();
		int response=0;
		int rowSize = input.get(0).get(0);
		int colSize = input.get(1).get(0);
		
		int sum = IntStream.range(0, rowSize*colSize).filter(index->(getValue(index, rowSize)!=Integer.MIN_VALUE)).sum();
		getLog().info("Q5 generated output: {}", sum);
	}

	private int getValue(int index, int rowSize) {
		if (index % rowSize == 0) {
			place++;
		}
//		getLog().info("index: {} and place: {}", index, place);
		if(place==index%rowSize) {
//			getLog().info("ReturnedValue: {}", input.get(2).get(index));
			return input.get(2).get(index);
		}
		return Integer.MIN_VALUE;
	}

	@Override
	public void populateData() {
		int rowSize = 3;//rnd.nextInt(NumericConstants.INT_TEN+1);
		int colSize = rowSize;
//				rnd.nextInt(NumericConstants.INT_FIVE+1);
		
		ArrayList<Integer> firstList = new ArrayList<Integer>();
		firstList.add(rowSize);
		input.add(firstList);
		
		ArrayList<Integer> secondList = new ArrayList<Integer>();
		secondList.add(colSize);
		input.add(secondList);

		ArrayList<Integer> thirdList = new ArrayList<Integer>();
		for(int index=0; index<rowSize*colSize; index++) {
			thirdList.add(rnd.nextInt(NumericConstants.INT_THOUSAND*2 + 1)-1000);
		}
		input.add(thirdList);
		getLog().info("Q5_GeneratedInput: {}", input);
	}

}
