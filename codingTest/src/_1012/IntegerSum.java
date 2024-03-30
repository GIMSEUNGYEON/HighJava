package _1012;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class IntegerSum {
	public static void main(String[] args) {
		int[] numbers = { 6, 10, 2 };

		List<String> list = new ArrayList<String>();

		for (int i = 0; i < numbers.length; i++) {
			list.add(Integer.toString(numbers[i]));
		}
		System.out.println(list);

		Collections.sort(list);
	}
}
