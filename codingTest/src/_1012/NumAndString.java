package _1012;

public class NumAndString {
	public static void main(String[] args) {
		String[] list = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
		String s = "one4three2five";
		for(int i = 0; i < 10; i++) {
			s = s.replace(list[i], Integer.toString(i));
		}
		
	}
}
