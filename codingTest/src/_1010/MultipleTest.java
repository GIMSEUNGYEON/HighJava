package _1010;

import java.util.ArrayList;
import java.util.List;

public class MultipleTest {
	public static void main(String[] args) {
		//n 이하의 수 중에 k의 배수를 오름차순으로 저장하는 배열
		int n = 10;
		int k = 3;
		List<Integer> answer = new ArrayList<Integer>();
		
		for(int i = 1; i<= n; i++) {
			if(i%k == 0) {
				answer.add(i);
			}
		}
		System.out.println(answer);
		

	}
}
