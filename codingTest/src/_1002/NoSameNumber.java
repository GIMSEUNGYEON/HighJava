package _1002;

import java.util.Queue;
import java.util.Stack;

public class NoSameNumber {
	public static void main(String[] args) {
		int []arr = {4,4,4,4,3,3};
		Stack<Integer> answer = new Stack<Integer>();
		for(int i : arr) {
		if(answer.isEmpty()) {
			answer.push(i);											
		}else if(answer.peek()!= i) {
			answer.push(i);
		}
			
		}
		System.out.println(answer);
		System.out.println(answer.peek());
	}
}
