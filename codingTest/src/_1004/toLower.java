package _1004;

import java.util.Arrays;

public class toLower {
	public static void main(String[] args) {
		// 정수 내림차순으로 배치하기
		// long 타입 숫자가 주어졌을 때 내침차순으로 정렬한 정수타입 리턴해주기
		// 예 ) 118372 => 873211
		long n = 118372L;
		String [] list = String.valueOf(n).split("");
		
		Arrays.sort(list);
		
		StringBuilder sb = new StringBuilder();
		for(String s : list) sb.append(s);
		
	}
}
