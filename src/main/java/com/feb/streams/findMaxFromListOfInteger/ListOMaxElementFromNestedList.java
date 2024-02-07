package com.feb.streams.findMaxFromListOfInteger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jan.commons.annotations.PickClassForExecution;
import com.jan.commons.annotations.PickMethodForExecution;
//@PickClassForExecution
public class ListOMaxElementFromNestedList {
	
	private static final Logger log = LogManager.getLogger(ListOMaxElementFromNestedList.class);
	
	public static List<Integer> solve(List<List<Integer>> input) {
		List<Integer> response = new ArrayList<>();
		response = input.stream().map(entry->entry.stream().max(Integer::compare).get()).collect(Collectors.toList());
		return response;
    }
	
//	@PickMethodForExecution
	public static void solve() {
		Random rnd = new Random();
		List<List<Integer>> nestedList= populateData(rnd);
		log.info("input {}", nestedList);
		List<Integer> solution = solve(nestedList);
		log.info("Solution {}", solution);
	}

	private static List<List<Integer>> populateData(Random rnd) {
		int rowSize = rnd.nextInt(100)+1;
		int colSize = rnd.nextInt(5)+1;
		List<List<Integer>> response = new ArrayList<>();
		for(int row= 0; row<rowSize; row++) {
			response.add(new ArrayList<>());
			for(int col = 0; col<colSize; col++) {
				response.get(row).add(rnd.nextInt(10000));
			}
		}
		return response;
	}

}
