package com.bendaten.trainer.chapter17;

import java.util.StringJoiner;

public class MyNameParser {

	public static String convert(String what) {
		StringJoiner sj = new StringJoiner(" ");
		for (String item : what.split(" ")) {
			sj.add(item.substring(0, 1).toUpperCase() + item.substring(1));
		}
		return sj.toString();
	}
}
