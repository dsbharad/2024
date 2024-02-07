package com.utils;

import java.util.Random;

import com.jan.commons.annotations.PickClassForExecution;
import com.jan.commons.annotations.PickMethodForExecution;

@PickClassForExecution
public interface ToBePickedForExecution {
	
	static final Random rnd = new Random();
	
	@PickMethodForExecution
	public void solve();
	
	void populateData();

}
