package com.feb.Day12.Q6;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jan.commons.annotations.PickClassForExecution;
import com.jan.commons.annotations.PickMethodForExecution;
import com.utils.NumericConstants;
import com.utils.ToBePickedForExecution;
@PickClassForExecution
public class Q6MultiplesOfEachElement implements ToBePickedForExecution {
	
	private static final Logger log = LogManager.getLogger(Q6MultiplesOfEachElement.class);
	private List<Integer> firstList = new ArrayList<Integer>();
	private List<Integer> secondList = new ArrayList<Integer>();

	@Override
	@PickMethodForExecution
	public void solve() {
		populateData();
		ArrayList<ArrayList<Integer>> response = new ArrayList<>();
        secondList.stream().forEach((divisor)->{
            ArrayList<Integer> listItem = new ArrayList<>();
            firstList.stream().filter(item->item%divisor==0).forEach(num->listItem.add(num));
            response.add(listItem);
        }
        );
        log.info("Q6 generated output: {}", response);
	}

	@Override
	public void populateData() {
		int sizeOfFirstList = rnd.nextInt(NumericConstants.INT_THOUSAND)+1;
		int sizeOfSecondList = rnd.nextInt(NumericConstants.INT_THOUSAND)+1;
		int maxSize = Math.max(sizeOfFirstList, sizeOfSecondList);
		for(int index = 0; index<maxSize; index++) {
			if(index<sizeOfFirstList) {
				firstList.add(rnd.nextInt(NumericConstants.INT_HUNDRED));
			}
			if(index<sizeOfSecondList) {
				secondList.add(rnd.nextInt(NumericConstants.INT_TEN)+1);
			}
		}
		log.info("Q6 generated input {}, {}", firstList, secondList);
	}

}
