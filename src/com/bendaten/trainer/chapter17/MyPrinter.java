package com.bendaten.trainer.chapter17;

public class MyPrinter {

	public void print(String what, MyParser how) {
		System.out.println(how.parse(what));
	}

}
