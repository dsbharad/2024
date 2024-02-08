package com.feb.streams.iterate_over_a_matrix;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jan.commons.annotations.PickClassForExecution;
import com.jan.commons.annotations.PickMethodForExecution;
import com.utils.NumericConstants;
import com.utils.ToBePickedForExecution;
//@PickClassForExecution
public class IterateOverAMatrix implements ToBePickedForExecution {
	
	private static final Logger log = LogManager.getLogger(IterateOverAMatrix.class);
	private int rowSize;
	private int colSize;
	private List<List<Integer>> input = new ArrayList<>();

	@Override
//	@PickMethodForExecution
	public void solve() {
		populateData();
		input.stream().flatMap(item->item.stream()).forEach(element->System.out.print(element + " "));
		System.out.println();
		System.out.println("=====================================================================");
		input.stream().forEach(row->{
			System.out.println();
			row.stream().forEach(item-> System.out.print(item + " "));
		});
		System.out.println();
		List<Iterator> iterList = input.stream().map(it->it.iterator()).collect(Collectors.toList());
		List<List<Object>> transposedMatrix = IntStream.range(0, colSize)
	       .mapToObj(n -> iterList.stream()
	       .filter(it -> it.hasNext())
	       .map(m -> m.next())
	       .collect(Collectors.toList()))
	   .collect(Collectors.toList());
		transposedMatrix.stream().forEach(row->{
			System.out.println();
			row.stream().forEach(item-> System.out.print(item + " "));
		});
	}

	public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A) {
        List<List<Integer>> interimCollection = new ArrayList<>();
        int colSize = A.get(0).size();
        List<Iterator> outerListIterator = A.stream().map(item->item.iterator()).collect(Collectors.toList());
        interimCollection = IntStream.range(0, colSize).mapToObj(index->outerListIterator.stream().map(listItem->(Integer)listItem.next()).collect(Collectors.toList())).collect(Collectors.toList());
        ArrayList<ArrayList<Integer>> response = new ArrayList<>();
        interimCollection.stream().forEach(innerList->{
        	ArrayList<Integer> tList=	new ArrayList<Integer>();
        	innerList.stream().forEach(element->tList.add(element));
        	response.add(tList);
        });
        return response;
    }

	@Override
	public void populateData() {
		rowSize = rnd.nextInt(NumericConstants.INT_FIVE)+1;
		colSize = rnd.nextInt(NumericConstants.INT_FIVE)+1;
		for(int row=0; row<rowSize; row++) {
			input.add(new ArrayList<Integer>());
			for(int col=0; col<colSize; col++) {
				input.get(row).add(rnd.nextInt(NumericConstants.INT_THOUSAND));
			}
		}
		log.info("Generated Input : {}", input);
	}

}
