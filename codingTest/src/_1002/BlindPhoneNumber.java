package _1002;

public class BlindPhoneNumber {
	public static void main(String[] args) {
		String phone_number = "01011113333";
		char[] ch = phone_number.toCharArray();
		for(int i = 0; i < ch.length - 4; i++) {
			ch[i] = '*';
		}
		String answer = String.valueOf(ch);
		System.out.println(answer);
	}
}
