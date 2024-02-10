package com.feb.Day12.Q4MatrixTranspose;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.jan.commons.annotations.PickClassForExecution;
import com.jan.commons.annotations.PickMethodForExecution;
import com.utils.BaseClass;
import com.utils.NumericConstants;
@PickClassForExecution
public class Q4MatrixTranspose extends BaseClass {
	
	private ArrayList<ArrayList<Integer>> input = new ArrayList<>();

	@Override
	@PickMethodForExecution
	public void solve() {
		populateData();
		ArrayList<ArrayList<Integer>> response = new ArrayList<>();
		IntStream.range(0,  input.size()).forEach(row->{
			ArrayList<Integer> rowList = new ArrayList<>();
			IntStream.range(0, input.get(row).size()).forEach(col->{
				rowList.add(input.get(col).get(row));
			});
			response.add(rowList);
		});
		getLog().info("Q4: Generated output: {}", response);
	}

	@Override
	public void populateData() {
		int rowSize = 3;//rnd.nextInt(NumericConstants.INT_THOUSAND)+1;
		int colSize = 3;//rnd.nextInt(NumericConstants.INT_THOUSAND)+1;
		IntStream.range(0, rowSize).forEach(row->{
			ArrayList<Integer> rowList = new ArrayList<>();
			IntStream.range(0, colSize).forEach(col->{
				rowList.add(rnd.nextInt(NumericConstants.INT_THOUSAND));
			});
			input.add(rowList);
		});
		getLog().info("Q4: Generated Input: {}", input);
		int B = 9;
		input.stream()
        .map(row->row.stream().map(item->B*item).collect(Collectors.toCollection(ArrayList::new)))
        .collect(Collectors.toCollection(ArrayList::new));
		input.stream()
        .map(row->row.stream().map(item->B*item).collect(ArrayList::new, ArrayList::add, ArrayList::addAll))
        .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
	}

}
