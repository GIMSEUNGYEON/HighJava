package _1004;

import java.util.Arrays;
import java.util.Collections;

public class toLowerString {
	public static void main(String[] args) {
		//문자열 s에 나타나는 문자를 큰 것부터 작은 순으로 정렬해 새로운 문자열을 리턴
		//s는 영문 대소문자로 구성되어있으며 대문자는 무조건 뒤로 간다
		String s = "Zbcdefg";
		String answer = "";
		String [] str = s.split("");
		Arrays.sort(str, Collections.reverseOrder());
		
		for(String a : str) {
			answer+=a;
		}
		System.out.println(answer);
		
		char ch = 'a';
		System.out.println((int)ch);
	}
}
