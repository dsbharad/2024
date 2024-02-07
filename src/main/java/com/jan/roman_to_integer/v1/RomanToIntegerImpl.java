package com.jan.roman_to_integer.v1;

import java.util.AbstractMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jan.commons.annotations.PickClassForExecution;
import com.jan.commons.annotations.PickMethodForExecution;

//@PickClassForExecution
public class RomanToIntegerImpl {
	private static final Logger log = LogManager.getLogger(RomanToIntegerImpl.class);

	private String input;

	private static Map<String, String> allowedRomanMap = Stream
			.of(new AbstractMap.SimpleImmutableEntry<String, String>("V", "I"),
					new AbstractMap.SimpleImmutableEntry<String, String>("X", "I"),
					new AbstractMap.SimpleImmutableEntry<String, String>("L", "X"),
					new AbstractMap.SimpleImmutableEntry<String, String>("C", "X"),
					new AbstractMap.SimpleImmutableEntry<String, String>("D", "C"),
					new AbstractMap.SimpleImmutableEntry<String, String>("M", "C"))
			.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

	private static Map<String, Integer> romanValueMap = Stream
			.of(new AbstractMap.SimpleImmutableEntry<String, Integer>("I", Integer.valueOf(1)),
					new AbstractMap.SimpleImmutableEntry<String, Integer>("V", Integer.valueOf(5)),
					new AbstractMap.SimpleImmutableEntry<String, Integer>("X", Integer.valueOf(10)),
					new AbstractMap.SimpleImmutableEntry<String, Integer>("L", Integer.valueOf(50)),
					new AbstractMap.SimpleImmutableEntry<String, Integer>("C", Integer.valueOf(100)),
					new AbstractMap.SimpleImmutableEntry<String, Integer>("D", Integer.valueOf(500)),
					new AbstractMap.SimpleImmutableEntry<String, Integer>("M", Integer.valueOf(1000)))
			.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

	public RomanToIntegerImpl() {
	}

	public RomanToIntegerImpl(String strInput) {
		strInput = strInput.toUpperCase();
		boolean proceed = proceedIfValidInput(strInput);
		if (proceed) {
			input = strInput;
		} else {
			input = "";
		}
	}

	private boolean proceedIfValidInput(String strInput) {
		String regex = "[IVXLCDM]";
		Pattern ptn = Pattern.compile(regex);
		Matcher matcher = ptn.matcher(strInput);
		return matcher.find();
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	@PickMethodForExecution
	public int solve() {
		int response = 0;
		String sample = "MCMXCCCLIV";
		RomanToIntegerImpl impl = new RomanToIntegerImpl(sample);
		response = impl.getIntegerValue();
		return response;
	}

	private int getIntegerValue() {
		int output = 0;
		int currentVal = 0;
		for (int place = 0; place < input.length(); place++) {
			String currentSymbol = String.valueOf(input.charAt(place));
			currentVal = romanValueMap.get(currentSymbol);
			if (place + 1 < input.length()) {
				String nextSymbol = String.valueOf(input.charAt(place + 1));
				if (nextSymbol != null && allowedRomanMap.get(nextSymbol) != null && allowedRomanMap.get(nextSymbol).equalsIgnoreCase(currentSymbol)) {
					currentVal = romanValueMap.get(nextSymbol) - currentVal;
					place++;
				}
			}
			output = output + currentVal;
		}
		log.info("Input: {}; output: {} " , input , output);
		return output;
	}

}
