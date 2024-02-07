package com.feb.lambdas;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.feb.lambdas.exceptions.EmployeeValidationException;

public class EmployeeLambdas {
	static Logger log = LogManager.getLogger(EmployeeLambdas.class);

	public static void main11(String[] args) {
		int val = 99;

		List<Employee> empList = generateEmpList();
		log.info(empList.stream().filter(item->item.isWorking()).count());
		System.out.println(empList.stream().filter(item->item.isWorking()).count());
		
		System.out.println(empList.stream().filter(ageFilter()).count());
		empList.stream().forEach(item->log.info(item.toString()));
		int reduce = empList.stream().mapToInt(item->item.getAge()).sum();
		String emptyStr = "";
		emptyStr.isBlank();
		log.info(Stream.of(1, 2, 3, 4, 7, 9).reduce(0,(a,b)->{
			log.info("a: {}; b: {}", a, b);
			return b+a;
			}));

	}

	private static Predicate<? super Employee> ageFilter() {
		return item->item.getAge()%3==0 || item.getAge()%5 ==0;
	}

	private static List<Employee> generateEmpList() {
		List<Employee> response = new ArrayList<Employee>();
		Random rnd = new Random();
		String generatedName;
		Employee newEmp = null;
		byte[] rndBytes = new byte[16];
		int size = rnd.nextInt(100);
		
		for (int index = 0; index < size; index++) {
			rnd.nextBytes(rndBytes);
			generatedName = new String(rndBytes, Charset.forName("UTF-8"));
			try {
				newEmp = new Employee.Builder().name(generatedName).age(rnd.nextInt(60)+1).isWorking(rnd.nextBoolean())
						.build();
				response.add(newEmp);
//				log.info(newEmp.toString());

			} catch (EmployeeValidationException e) {
				e.printStackTrace();
			}
		}
		return response;
	}
}
