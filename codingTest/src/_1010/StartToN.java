package _1010;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StartToN {
	public static void main(String[] args) {
		//정수 배열 num_list와 정수 n이 주어질 때  n번쨰 원소부터 마지막 원소까지를 담은 배열을 return
		int[] num_list = {2,1,6};
		int n = 3;
		List<Integer> answer = new ArrayList<Integer>();
		
		for(int i = n - 1; i < num_list.length; i ++) {
			answer.add(num_list[i]);
		}
		System.out.println(answer);
		
//		int[] a = Arrays.copyOfRange(num_list, n - 1, num_list.length);
		int[] a = Arrays.copyOfRange(num_list, 0, n);
		
		System.out.println(Arrays.toString(a));
	}
}
