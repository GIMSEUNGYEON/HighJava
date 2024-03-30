package _1030;

public class OddString {
	public static void main(String[] args) {
		String s = "try hello world";

//		String s = "abc   adfa  ";
		
		String answer = "";
		
		String [] arr = s.toLowerCase().split("");
		
		int count = 0;
		
		for(String str : arr) {
			count = str.contains(" ") ? 0 : count + 1;
			answer += (count %2 == 0) ? str : str.toUpperCase();
			
		}
		System.out.println(answer);
	}
}
