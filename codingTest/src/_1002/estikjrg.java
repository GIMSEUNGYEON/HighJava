package _1002;

public class estikjrg {
	public static void main(String[] args) {
		String str = "())";
		
		boolean answer = true;
		
		int count = 0;
		for(char ch : str.toCharArray()) {
			count += (ch == '(') ? 1 : -1;
			if(count < 0) answer = false;
		}
		System.out.println(answer);
	}
}
