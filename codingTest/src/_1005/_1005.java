package _1005;
import java.util.Arrays;

public class _1005 {
	public static void main(String[] args) {
		String my_string = "nice to meet you";
		String answer = "";
		String remove = "aeiou";
		String [] as = {"a","e","i","o","u"};
		
		for(String re : as) {
			if(my_string.contains(re)) {
				my_string = my_string.replace(re, "");
			}
		}
		System.out.println(my_string);
		
		String letter = "n";
		
		my_string = my_string.replace(String.valueOf(letter), "");
		
		System.out.println(my_string);
		
		int n = 12345;
		int answer1 = 0;
		while(n>0) {
			answer1+=n%10;
			n/=10;
		}
		System.out.println(answer1);
		
		String test = "jaron";
		StringBuilder dsfa = new StringBuilder();
		dsfa.append(test);
		System.out.println(dsfa.reverse());
		
		String hello = "hello";
		int nn = 3;
		String[] hellooo = hello.split("");
		for(int i = 0; i < hello.length(); i++) {
			for(int j = 0; j < nn; j++) {
				
			}
		}
		
		int [] sides = {199, 72, 222};
		Arrays.sort(sides);
		int temp = 0;
		for(int i = 0; i < sides.length - 1; i ++){
			System.out.println(i);
			temp+=sides[i];
		}
		System.out.println("최댓값 : " + sides[sides.length-1]);
		System.out.println("나머지 합 : " + temp);
		int answer3 = (temp > sides[sides.length-1]) ? 1 : 2;
		
		System.out.println(answer3);
		
		int m = 144;
		System.out.println(Math.sqrt(m));
		
		String banana = "banana";
		String ana = "ana";
		banana.contains(ana);
	}
	
}
