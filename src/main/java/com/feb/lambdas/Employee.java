package com.feb.lambdas;

import com.feb.lambdas.exceptions.EmployeeValidationException;

public class Employee {

	private String name;
	private int age;
	private boolean isWorking;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isWorking() {
		return isWorking;
	}

	public void setWorking(boolean isWorking) {
		this.isWorking = isWorking;
	}

	public Employee(String name, int age, boolean isWorking) {
		super();
		this.name = name;
		this.age = age;
		this.isWorking = isWorking;
	}

	public static Employee Of(String name, int age, boolean isWorking) {
		Employee response = new Employee(name, age, isWorking);
		return response;
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", isWorking=" + isWorking + "]";
	}

	public static class Builder {

		private String name;
		private int age;
		private boolean isWorking;

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder age(int age) throws EmployeeValidationException {
			EmployeeValidator.ageValidator(age);
			this.age = age;
			return this;
		}

		public Builder isWorking(Boolean value) {
			this.isWorking = value;
			return this;
		}

		public Employee build() {
			Employee response = new Employee(this.name, this.age, this.isWorking);
			return response;
		}
	}

}
