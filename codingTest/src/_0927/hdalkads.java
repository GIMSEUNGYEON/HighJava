package _0927;

import java.util.ArrayList;
import java.util.List;

public class hdalkads {
	public static void main(String[] args) {
		int x = 4;
		int n = 3;
		
		List<Double> answer = new ArrayList<Double>();
		
		for(double i = 1; i < n+1; i++) {
			answer.add((double)x*i);
		}
		System.out.println(answer);
	}
}
