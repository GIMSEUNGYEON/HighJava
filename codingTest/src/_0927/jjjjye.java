package _0927;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class jjjjye {
	public static void main(String[] args) {
		int [] arr = {8,32123,4567,876,3,6,456};
		 List<Integer> answer = new ArrayList<Integer>();

	        if(arr.length == 1){
	            answer.add(-1);
	        }else{
	            for(int i : arr){
	            	answer.add(i);
	                }
	            }
	        System.out.println(answer);
	            int min = Collections.min(answer);
	            answer.remove(answer.indexOf(min));
	            System.out.println(answer);
	        }
	}
