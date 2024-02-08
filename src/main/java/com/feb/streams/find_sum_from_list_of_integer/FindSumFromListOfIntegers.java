package com.feb.streams.find_sum_from_list_of_integer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jan.commons.annotations.PickClassForExecution;
import com.jan.commons.annotations.PickMethodForExecution;
import com.utils.NumericConstants;
import com.utils.ToBePickedForExecution;

//@PickClassForExecution
public class FindSumFromListOfIntegers implements ToBePickedForExecution {
	private static final Logger log = LogManager.getLogger(FindSumFromListOfIntegers.class);

	private int rowCount;
	private int colCount;
	private List<List<Integer>> input = new ArrayList<>();

	@Override
//	@PickMethodForExecution
	public void solve() {
		populateData();
		solve(rowCount, colCount, input);
	}

	@Override
	public void populateData() {
		rowCount = rnd.nextInt(NumericConstants.INT_THOUSAND) + 3;
		colCount = rnd.nextInt(NumericConstants.INT_THOUSAND) + 3;
		for (int row = 0; row < rowCount; row++) {
			input.add(new ArrayList<>());
			for (int col = 0; col < colCount; col++) {
				input.get(row).add(rnd.nextInt(NumericConstants.INT_THOUSAND) + 1);
			}
		}
		log.info("Generated data: {}", input);
	}

	private ArrayList<Integer> solve(int A, int B, List<List<Integer>> C) {
		ArrayList<Integer> response = new ArrayList<>();
		int[] rowArray = new int[colCount];
		C.stream().forEach((row -> {
			for (int i = 0; i < colCount; i++) {
				rowArray[i] += (int) row.get(i);
			}
		}));
		Arrays.stream(rowArray).forEach(item -> response.add(item));
		log.info("response: {}", response);
		
		findTranspose(A, B, C);
		
		return response;
	}

	private void findTranspose(int rowSize, int colSize, List<List<Integer>> matrix) {
		List<List<Integer>> response = new ArrayList<>();
		final int N = matrix.stream().mapToInt(l -> l.size()).max().orElse(-1);
		   List<Iterator> iterList = matrix.stream().map(it->it.iterator()).collect(Collectors.toList());
		   Stream<List<Object>> mapToObj = IntStream.range(0, N)
		       .mapToObj(index -> iterList.stream()
//		       .filter(it -> it.hasNext())
		       .map(itr -> itr.next())
		       .collect(Collectors.toList()));
		   System.out.println();
		   mapToObj.forEach(item->System.out.print(item + " "));
		   System.out.println();
		
	}

}
