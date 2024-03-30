package _1005;

public class Third {
	public static void main(String[] args) {
		int n = 45;
		String s = "";
		while (n != 0) {
			s += n % 3;
			n /= 3;
		}
		System.out.println(s);

		int answer = Integer.parseInt(s, 3);
		System.out.println(answer);

	}
}
