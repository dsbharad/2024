package com.feb.streams.equality_of_two_matrices;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jan.commons.annotations.PickClassForExecution;
import com.jan.commons.annotations.PickMethodForExecution;
import com.utils.NumericConstants;
import com.utils.ToBePickedForExecution;
@PickClassForExecution
public class EqualityOfMatricesCheck implements ToBePickedForExecution {
	
	private static final Logger log = LogManager.getLogger(EqualityOfMatricesCheck.class);
	private int rowSize;
	private int colSize;
	private List<List<Integer>> firstList = new ArrayList<>();
	private List<List<Integer>> secondList = new ArrayList<>();
	private List<Integer> flattenedFirstList;
	private List<Integer> flattenedSecondList;

	@Override
	@PickMethodForExecution
	public void solve() {
		populateData();
		flattenedFirstList = firstList.stream().flatMap(row->row.stream()).collect(Collectors.toList());
		flattenedSecondList = secondList.stream().flatMap(row->row.stream()).collect(Collectors.toList());
		long count = IntStream.range(0, flattenedFirstList.size()).filter(index -> flattenedFirstList.get(index).compareTo(flattenedSecondList.get(index))!=0).count();
		IntStream filter = IntStream.range(0, flattenedFirstList.size()).filter(index -> flattenedFirstList.get(index).compareTo(flattenedSecondList.get(index))!=0);
		System.out.print(count);
	}

	@Override
	public void populateData() {
		rowSize= rnd.nextInt(NumericConstants.INT_HUNDRED)+1;
		colSize= rnd.nextInt(NumericConstants.INT_HUNDRED)+1;
		int rndNum;
		for(int row=0; row<rowSize; row++) {
			firstList.add(new ArrayList<Integer>());
			secondList.add(new ArrayList<Integer>());
			for(int col=0; col<colSize; col++) {
				rndNum = rnd.nextInt(NumericConstants.INT_THOUSAND);
				firstList.get(row).add(rndNum);
				secondList.get(row).add(rndNum);
			}
		}
		log.info("input: {}", firstList);
	}

}
