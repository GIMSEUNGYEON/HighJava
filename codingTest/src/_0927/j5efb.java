package _0927;

import java.util.Arrays;

public class j5efb {
	public static void main(String[] args) {
		int [] numbers = {1,2,3,4,6,7,8,0};
		
		int answer = 0;
		for(int i = 1; i < 10; i++) {
			answer+=i;
		}
		for(int i : numbers) {
			answer-=i;
		}
		System.out.println(answer);
	}
		
}
