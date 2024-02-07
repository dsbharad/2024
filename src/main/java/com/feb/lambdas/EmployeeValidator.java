package com.feb.lambdas;

import com.feb.lambdas.exceptions.EmployeeValidationException;
import com.feb.lambdas.utils.ErrorCodes;

public class EmployeeValidator {
	
	public static Boolean ageValidator(int input) throws EmployeeValidationException{
		boolean response = (0<input && input <75);
		if(!response) {
			throw new EmployeeValidationException("Invalid age", ErrorCodes.INVALID_AGE_INPUT);
		} else {
			return response;
		}
	}

}
