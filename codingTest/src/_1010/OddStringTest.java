package _1010;

import java.util.Arrays;

public class OddStringTest {
	public static void main(String[] args) {
		//이상한 문자열 만들기 문자열 s는 한개 이상의 단어로 구성되어있습니다. 각 단어는 하나 이상의 공백문자로 구성되어 있습니다.
		//각 단어의 짝수번쨰 알파벳은 대문자로, 홀수번쨰 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수를 완성하세요.
		//문자열 전체의 짝홀 인덱스가 아니라, 공백 기준 별로 짝 홀 인덱스를 판단해야합니다. 첫번째 글자는 0번째 인덱스로 간주하여 짝수번째로 처리합니다.
		//입출력 예 : try hello world => TrY HeLlO WoRlD
		
		String s  = "try hello world";
		String [] tmp = s.split(" ");
		
		System.out.println(Arrays.toString(tmp));
		
		for(int i = 0; ; i+=2) {
			if(tmp[i].charAt(i)%2 == 0) {
//				tmp[i].charAt(i).toUpper
			}
		}
		
	}
}
