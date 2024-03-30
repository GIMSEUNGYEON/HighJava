package _1002;

public class SuBak {
	public static void main(String[] args) {
		int n = 3;
		String answer = "";
		for(int i = 1; i <= n; i++) {
			answer += (i%2!=0) ? "수" :"박";
			
		}
		System.out.println(answer);
	}
}
