package _1010;

import java.util.Arrays;

public class H_Index {
	public static void main(String[] args) {
		// h번 이상 인용된 논문이 h 이상일 때  답이 h
		// [3,0,6,1,5] => 3
		
		int [] citations = {3,0,6,1,5};
		
		Arrays.sort(citations);
		
		int answer = 0;
		System.out.println(Arrays.toString(citations));
		
		for(int i = 0; i < citations.length; i++) {
			int h = citations.length -i;
			if(citations[i] >= h) {
				answer = h;
				break;
			}
		}
		System.out.println(answer);

		 int max = 0;
	        for(int i = citations.length-1; i > -1; i--){
	            int min = (int)Math.min(citations[i], citations.length - i);
	            if(max < min) max = min;
	        }
	
	        System.out.println(max);
	}
	
	
}
