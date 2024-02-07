package com.feb.myInterfaces;

public class MyAbstractClass2 implements testInterface {
	public Integer data = 1;
	@Override
	public void instanceMethod1() {
		data = data + data;
	}

}
