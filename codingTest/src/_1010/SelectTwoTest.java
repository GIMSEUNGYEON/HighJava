package _1010;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SelectTwoTest {
	public static void main(String[] args) {
		//주어진 배열에서 서로 다른 인덱스에 있는 두 수를 뽑아 더해서 만들 수 있는 모든 경우의 수
		int [] numbers = {5,0,2,7};
		Set<Integer> result = new TreeSet<Integer>(); 
		for(int i = 0; i < numbers.length; i++) {
			for(int j = 0; j < numbers.length; j++) {
				if(i != j) {
					result.add(numbers[i] + numbers[j]);
				}
			}
		}
		System.out.println(result);
	}
}
