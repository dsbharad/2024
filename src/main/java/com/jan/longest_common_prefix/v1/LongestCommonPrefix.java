package com.jan.longest_common_prefix.v1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jan.commons.annotations.PickClassForExecution;
import com.jan.commons.annotations.PickMethodForExecution;

@PickClassForExecution
public class LongestCommonPrefix {
	private static final Logger log = LogManager.getLogger("LongestCommonPrefix.class");
	
	public LongestCommonPrefix() {
 }
	
	@PickMethodForExecution
	public String solve() {
		String response = "";
		
		String str1, str2;
		str1 = "elevate";
		str2 = "elevated";
		System.out.println(str2.indexOf(str1));
		log.info("Longest Common Prefix is : " + response);
		return response;
	}

}
