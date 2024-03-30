package _1012;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class hfdsfhsdf {
	public static void main(String[] args) {
		
	int k = 3;
	int [] score = {10, 100, 20, 150, 1, 100, 200};
	int [] answer = new int[score.length];
	ArrayList<Integer> tmp = new ArrayList<Integer>();
	 
	 for(int i = 0; i < score.length; i++) {
		 if(tmp.size() < k) {
			 tmp.add(score[i]);
		 }else {
			 if(tmp.get(0) < score[i]) {
				 tmp.set(0, score[i]);
			 }
		 }
		 Collections.sort(tmp);
		 answer[i] = tmp.get(0);
	 }
	 System.out.println(Arrays.toString(answer));
	
	}
}
