package _1012;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class IntegerTrimTest {
	public static void main(String[] args) {
		double flo = 1.42;
		int result = (int)flo;
		
		int [] arr = {1,2,3,100,99,98};
		
		int [] answer = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] >= 50 && arr[i]%2==0 ) {
				answer[i] = arr[i]/2;
			}else if(arr[i] < 50 && arr[i]%2 != 0) {
				answer[i] = arr[i]*2;
				
			}else {
				answer[i] = arr[i];
			}
		}
		
		System.out.println(Arrays.toString(answer));
		
		String myString = "Programmers1234";
		
		int n = 11;
		
		String res = myString.substring(myString.length() - n, myString.length());
		
		System.out.println(res);
		
		int [] num_list = {7,3,7,74,12,65,12};
		
		Arrays.sort(num_list);
		
		int [] ans = Arrays.copyOfRange(num_list, num_list.length - 5 ,num_list.length );
		
		System.out.println(Arrays.toString(ans));
		
		List<Integer> num = new ArrayList<Integer>();
		
		for(int i : num_list) {
			num.add(i);
		}
		
		System.out.println(num.contains(3));
		
		String str = "10";
		
		int i = Integer.parseInt(str);
				
				
	}
}
