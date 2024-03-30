package _1005;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HiddenNumber {
	public static void main(String[] args) {
		
	String my_string = "aAb1B2cC34oOp";
	
	String [] arr = (my_string.replaceAll("[^0-9]", "").split(""));
	
	int answer = 0;
	for(String s : arr) {
		answer +=Integer.parseInt(s);
	}
	System.out.println(answer);
	
	String str1 = "ab6CDE443fgh22iJKlmn1o";
	String str2 = "6CD";
	
	int b = (str1.contains(str2)) ? 1 : 2;
	
	System.out.println(b);
	
	int[] array = {1,2,7,10,11};
	List<Integer> list = new ArrayList<Integer>();
	for(int i : array) {
		list.add(i);
	}
	Collections.sort(list);
	System.out.println(list);
	int answer1 = list.get(array.length/2);
	System.out.println(answer1);
	
	Arrays.sort(array);
	}
}
