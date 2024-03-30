package _1002;

public class MaxMinLv2 {
	public static void main(String[] args) {
		String s = "-1 -1";
		String [] strArr = s.split(" ");
		
		int [] intArr = new int[strArr.length];
		for(int i = 0; i < intArr.length; i++) {
			intArr[i] = Integer.parseInt(strArr[i]);
		}
		int min = intArr[0];
		int max = intArr[0];
		
		for(int i : intArr) {
			if(i < min) {
				min = i;
			}
			if(i > max) {
				max = i;
			}
		}

		System.out.println(min);
		System.out.println(max);
		String answer = "" + min + " " + max;
		
		System.out.println(answer);
	}
}
